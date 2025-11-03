package lotto;

import lotto.service.LottoService;
import lotto.util.InputValidator;
import lotto.domain.Lotto;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int purchaseAmount = InputValidator.readPurchaseAmount();
        int lottoCount = purchaseAmount / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<Lotto> lottos = LottoService.generateLottos(lottoCount);
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        // 다음 단계: 당첨 번호 입력 및 당첨 판정
    }
}
