package lotto;

import lotto.util.InputValidator;
import lotto.service.LottoService;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

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

        List<Integer> winningNumbers = InputValidator.readWinningNumbers();
        int bonusNumber = InputValidator.readBonusNumber();
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // TODO: LottoService로 당첨 판정, 통계 출력
    }
}
