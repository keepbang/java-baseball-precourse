package baseball.domain;

import baseball.type.ScoreType;

public class Score {
    private int strike;
    private int ball;

    public Score(int strike, int ball){
        this.strike = strike;
        this.ball = ball;
    }

    public void addStrike(){
        this.strike++;
    }

    public void addBall(){
        this.ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void refereeScore(ScoreType scoreType) {
        if(scoreType.isStrike()){
            this.addStrike();
        }
        if(scoreType.isBall()){
            this.addBall();
        }
    }
}
