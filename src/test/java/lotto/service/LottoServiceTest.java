package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    void 로또_발행_개수_확인() {
        List<Lotto> lottos = lottoService.generateLottos(5);
        assertThat(lottos).hasSize(5);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(6);
        }
    }

    @Test
    void 당첨_통계_계산_확인() {
        Lotto winning = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(
                new Lotto(List.of(1, 2, 3, 7, 8, 9)), // 3개
                new Lotto(List.of(1, 2, 3, 4, 5, 6))  // 6개
        );

        var result = lottoService.calculateStatistics(lottos, winning, 7);

        assertThat(result.get(Rank.FIRST)).isEqualTo(1);  // 6개 일치
        assertThat(result.get(Rank.FIFTH)).isEqualTo(1);  // 3개 일치
    }
}
