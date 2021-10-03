package baseball.controller;

import baseball.domain.Ball;

import baseball.type.GameStatus;
import baseball.utils.RandomGenerator;
import nextstep.utils.Console;

import static baseball.view.OutputView.*;

/**
 * Author       : keepbang
 * Description  : 게임 플레이를 위한 Controller
 */
public class BaseballGame {

    private GameStatus gameStatus = GameStatus.RESTART;

    public void start(){
        while(!gameStatus.isEnd()){
            Ball randomPlayerBall = RandomGenerator.getRandomPlayerBall();

            PlayBaseballGame playBaseballGame = new PlayBaseballGame(randomPlayerBall);
            playBaseballGame.play();
            gameEndOutput();
            gameStatus = getGameEndAnswer();
        }
    }

    private GameStatus getGameEndAnswer(){
        GameStatus status = GameStatus.ERROR;
        while(!status.isNotError()){
            gameRetryAnswer();
            String input = Console.readLine();
            status = getGameStatusByAnswer(input);
        }
        return status;
    }

    private GameStatus getGameStatusByAnswer(String input){
        if(!input.matches("[1,2]")){
            printError("잘못 입력했습니다.");
            return GameStatus.ERROR;
        }
        if("1".equals(input)){
            return GameStatus.RESTART;
        }
        return GameStatus.END;
    }

}
