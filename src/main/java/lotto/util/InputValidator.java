package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class InputValidator {

    // 구입 금액 입력 + 검증
    public static int readPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                int amount = Integer.parseInt(input);
                if (amount < 1000 || amount % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // TODO: 당첨 번호, 보너스 번호 입력 메서드 추가 예정
}
