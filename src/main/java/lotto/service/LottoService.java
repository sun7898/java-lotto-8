package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.*;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoService {

    public List<Lotto> generateLottos(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public Map<Rank, Integer> calculateStatistics(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();

            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, bonusMatch);
            if (rank != null) {
                result.put(rank, result.get(rank) + 1);
            }
        }
        return result;
    }
}
