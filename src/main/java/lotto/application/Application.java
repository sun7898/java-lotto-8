package lotto;

import lotto.util.InputValidator;
import lotto.service.LottoService;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        int purchaseAmount = InputValidator.readPurchaseAmount();
        int lottoCount = purchaseAmount / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<Lotto> lottos = LottoService.generateLottos(lottoCount);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        List<Integer> winningNumbers = InputValidator.readWinningNumbers();
        int bonusNumber = InputValidator.readBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        Map<Rank, Integer> statistics = LottoService.calculateStatistics(lottos, winningLotto);

        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", statistics.get(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", statistics.get(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", statistics.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", statistics.get(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", statistics.get(Rank.FIRST));

        double yield = LottoService.calculateYield(lottos, statistics);
        System.out.println("총 수익률은 " + yield + "%입니다.");
    }
}
