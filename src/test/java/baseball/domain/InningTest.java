package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InningTest {

    @ParameterizedTest
    @CsvSource(value = {
            "123,132,1,2",
            "537,137,2,0",
            "729,729,3,0",
            "153,175,1,1",
            "123,218,0,2",
            "987,798,0,3",
            "123,789,0,0"
    },delimiter = ',')
    @DisplayName("한 이닝에 대한 play 결과 테스트")
    void InningPlayTest(String computer, String player, Integer strike, Integer ball){
        Inning inning = playGame(computer, player);

        Score score = inning.getScore();

        assertThat(score.getStrike()).isEqualTo(strike);
        assertThat(score.getBall()).isEqualTo(ball);

    }

    @ParameterizedTest
    @CsvSource(value = {
            "367,367,true",
            "123,193,false"
    },delimiter = ',')
    @DisplayName("게임이 종료되었는지 테스트")
    void isGameEndTest(String computer, String player,boolean isGameEnd){
        Inning inning = playGame(computer, player);

        assertThat(inning.isGameEnd()).isEqualTo(isGameEnd);
    }

    public Inning playGame(String computer, String player){
        Inning inning = new Inning();
        PlayerBall computerBall = PlayerBall.createPlayerBall(computer);
        PlayerBall playerBall = PlayerBall.createPlayerBall(player);

        inning.play(computerBall, playerBall);
        return inning;
    }
}