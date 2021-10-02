package baseball.utils;

import baseball.domain.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.domain.PlayerBall.*;
import static baseball.utils.RandomGenerator.getRandomPlayerBall;
import static org.assertj.core.api.Assertions.assertThat;


public class RandomGeneratorTest {

    @Test
    @DisplayName("서로 다른 수로 이루어진 숫자인지 확인")
    void getRandomPlayerBallTest(){
        Ball randomPlayerBall = getRandomPlayerBall();

        List<Integer> numbers = randomPlayerBall.getNumbers();

        Set<Integer> distinctSet = new HashSet<>(numbers);

        assertThat(distinctSet.size()).isEqualTo(MAX_RANGE);
    }

}