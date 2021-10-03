package baseball.type;

public enum ScoreType {
    STRIKE, BALL, NOTHING;

    public boolean isStrike() {
        return this.equals(STRIKE);
    }

    public boolean isBall() {
        return this.equals(BALL);
    }
}
