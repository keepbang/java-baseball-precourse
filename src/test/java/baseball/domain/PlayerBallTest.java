package baseball.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class PlayerBallTest {
    @ParameterizedTest
    @ValueSource(strings = {
            "123","789","789"
    })
    void 볼생성_성공(String input){
        assertThatCode(() -> PlayerBall.createPlayerBall(input)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0","000",""," ","   ",
            "1111","1000","9999",
            "+0","-99","_",
            "123abcd","abc","ab3",
            "123-12","11 ","1 9"," 12",
            " 342","123 ","111","999"
    })
    void 볼생성_실패(String input){
        assertThatThrownBy(() -> PlayerBall.createPlayerBall(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


}