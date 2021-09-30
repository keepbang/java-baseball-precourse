package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PlayerBallTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "111","999","123","789"
    })
    void 볼생성_성공(String input){
        assertDoesNotThrow(() -> new PlayerBall(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0","000",""," ","   ",
            "1111","1000","9999",
            "+0","-99","_",
            "123abcd","abc","ab3",
            "123-12","11 ","1 9"," 12",
            " 342","123 "
    })
    void 볼생성_실패(String input){
        assertThatThrownBy(() -> new PlayerBall(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}