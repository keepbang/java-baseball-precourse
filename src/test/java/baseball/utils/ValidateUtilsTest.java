package baseball.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static baseball.domain.PlayerBall.MAX_RANGE;
import static baseball.utils.ValidateUtils.validation;
import static org.assertj.core.api.Assertions.*;


class ValidateUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "123", "456", "789"
    })
    void 입력숫자_검증_성공(String input) {
        assertThatCode(() -> validation(input)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1", "12", "1234", " ", "   ", "    ",
            "a1", "as2", "f12", "-1", "+34", "abc",
            "1 2", " 45", "67 ", "968-231", "12+345","000","0"
    })
    @DisplayName("숫자/3자릿수 실패 테스트")
    void 입력숫자_검증_실패(String input) {

        assertThatIllegalArgumentException().isThrownBy(() -> validation(input))
        .withMessageMatching("1부터 9까지의 숫자 "+MAX_RANGE+"자리를 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "111","222","999"
    })
    @DisplayName("숫자/3자릿수 실패 테스트")
    void 중숫자_검증_실패(String input) {

        assertThatIllegalArgumentException().isThrownBy(() -> validation(input))
                .withMessageMatching("중복된 숫자가 입력되었습니다.");
    }
}
