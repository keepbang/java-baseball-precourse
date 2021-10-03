package baseball.domain;

import baseball.type.ScoreType;

import java.util.List;

import static baseball.domain.PlayerBall.MAX_RANGE;

public class Inning {
    private Score score;

    public Inning(){
        this.score = new Score(0,0);
    };

    public void play(Ball randomBall, Ball playerBall) {
        List<Integer> randomNumbers = randomBall.getNumbers();
        for (int i = 0; i < randomNumbers.size(); i++) {
            Integer randomNumber = randomNumbers.get(i);
            ScoreType scoreType = refereePlay(playerBall, randomNumber, i);
            score.refereeScore(scoreType);
        }
    }

    private ScoreType refereePlay(Ball playerBall, int randomNumber, int round){
        List<Integer> playerNumbers = playerBall.getNumbers();
        if(playerNumbers.get(round) == randomNumber){
            return ScoreType.STRIKE;
        }
        if(playerNumbers.contains(randomNumber)){
            return ScoreType.BALL;
        }
        return ScoreType.NOTHING;
    }

    public boolean isGameEnd(){
        return score.getStrike() == MAX_RANGE;
    }

    public Score getScore() {
        return score;
    }
}
