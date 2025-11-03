package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    public List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public Map<Rank, Integer> calculateStatistics(List<Lotto> lottos, Lotto winning, int bonusNumber) {
        Map<Rank, Integer> statistics = new HashMap<>();
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winning.getNumbers()::contains)
                    .count();

            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            Rank rank = Rank.valueOf(matchCount, bonusMatch);
            statistics.put(rank, statistics.get(rank) + 1);
        }

        return statistics;
    }
}
