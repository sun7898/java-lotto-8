package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class InputValidator {

    public static int readPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int amount = Integer.parseInt(Console.readLine().trim());
            validatePurchaseAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해야 합니다.");
            return readPurchaseAmount(); // 재귀로 재입력
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPurchaseAmount(); // 재귀로 재입력
        }
    }

    public static void validatePurchaseAmount(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }
}
