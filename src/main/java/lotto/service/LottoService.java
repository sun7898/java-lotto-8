package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    public static List<Lotto> generateLottos(int count) {
        // 기존 구현 그대로
        List<Lotto> lottos = new java.util.ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange(1, 45, 6);
            java.util.Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public static Map<Rank, Integer> calculateStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<Rank, Integer> statistics = new HashMap<>();
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningLotto.getWinningNumbers()::contains)
                    .count();
            boolean bonusMatch = lotto.getNumbers().contains(winningLotto.getBonusNumber());
            Rank rank = getRank(matchCount, bonusMatch);
            statistics.put(rank, statistics.get(rank) + 1);
        }

        return statistics;
    }

    private static Rank getRank(int matchCount, boolean bonusMatch) {
        if (matchCount == 6) return Rank.FIRST;
        if (matchCount == 5 && bonusMatch) return Rank.SECOND;
        if (matchCount == 5) return Rank.THIRD;
        if (matchCount == 4) return Rank.FOURTH;
        if (matchCount == 3) return Rank.FIFTH;
        return Rank.NONE;
    }

    public static double calculateYield(List<Lotto> lottos, Map<Rank, Integer> statistics) {
        long totalPrize = statistics.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
        long totalSpent = lottos.size() * 1000L;
        return Math.round((totalPrize / (double) totalSpent) * 1000) / 10.0; // 소수점 둘째 자리 반올림
    }
}
