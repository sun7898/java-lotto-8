package lotto.util;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @Test
    void 구입금액_검증_예외() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount(1234))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호_범위_검증_예외() {
        assertThatThrownBy(() -> InputValidator.validateLottoNumbers(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validateLottoNumbers(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_범위_검증_예외() {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
