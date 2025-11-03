package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    public static int readPurchaseAmount() { /* 기존 구현 */ }

    public static List<Integer> readWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();
                List<Integer> numbers = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                if (numbers.size() != 6) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
                }
                for (int num : numbers) {
                    if (num < 1 || num > 45) {
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                }
                return numbers;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int readBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int bonus = Integer.parseInt(Console.readLine().trim());
                if (bonus < 1 || bonus > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
                }
                return bonus;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
