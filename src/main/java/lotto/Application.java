package lotto;

import lotto.service.LottoService;
import lotto.util.InputValidator;

public class Application {

    public static void main(String[] args) {
        int purchaseAmount = readPurchaseAmount();
        System.out.println((purchaseAmount / 1000) + "개를 구매했습니다.");

        LottoService lottoService = new LottoService();
        // 예시: 로또 발행 및 통계 출력
        // lottoService.generateLottos(purchaseAmount / 1000);
        // lottoService.calculateStatistics(...);
    }

    // 구입 금액 입력 및 검증
    public static int readPurchaseAmount() {
        try {
            return InputValidator.readPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readPurchaseAmount(); // 재귀로 재입력
        }
    }
}
