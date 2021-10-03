package baseball.controller;

import baseball.domain.Ball;
import baseball.domain.Inning;
import baseball.domain.PlayerBall;
import baseball.view.OutputView;
import nextstep.utils.Console;

import static baseball.view.OutputView.inningResultOutput;
import static baseball.view.OutputView.printError;

/**
 * Author       : keepbang
 * Description  : 1게임 플레이를 위한 Controller
 */
public class PlayBaseballGame {

    private Ball randomBall;

    public PlayBaseballGame(Ball randomBall){
        this.randomBall = randomBall;
    };

    public void play(){
        boolean isEnd = false;

        while(!isEnd){
            isEnd = playGame();
        }
    }

    public boolean playGame(){
        try{
            PlayerBall playerBall = enterPlayerNumber();
            Inning inning = inningStart(playerBall);
            inningResultOutput(inning.getScore());
            return inning.isGameEnd();
        }catch(IllegalArgumentException e){
            printError(e.getMessage());
            return false;
        }
    }

    private PlayerBall enterPlayerNumber(){
        OutputView.enterNumber();
        String input = Console.readLine();
        return PlayerBall.createPlayerBall(input);
    }

    private Inning inningStart(PlayerBall playerBall){
        Inning inning = new Inning();
        inning.play(randomBall, playerBall);
        return inning;
    }

}
