package lotto;

import lotto.util.InputValidator;

public class Application {

    public static void main(String[] args) {
        // 기존 구입 금액 입력 코드 삭제 → InputValidator로 이동
        int purchaseAmount = InputValidator.readPurchaseAmount();

        // TODO: LottoService로 로또 생성, 당첨 판정, 통계 출력
    }
}
