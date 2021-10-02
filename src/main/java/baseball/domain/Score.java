package baseball.domain;

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
}
