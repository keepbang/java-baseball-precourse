package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "111","999","123","456","789","444"
    })
    void 정규식_검증_성공(String number){
        boolean matches = number.matches("^[1-9]{3}");

        assertThat(matches).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0",""," ","   ",
            "1111","1000","9999",
            "+0","-99","_",
            "123abcd","abc","ab3",
            "123-12","11 ","1 9"," 12",
            " 342","123 "
    })
    void 정규식_검증_실패(String number){
        boolean matches = number.matches("^[1-9]{3}");

        assertThat(matches).isFalse();
    }

}