package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

class ApplicationTest extends NsTest {

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j"); // 잘못된 입력값
            output().contains("[ERROR]");
        });
    }
}
