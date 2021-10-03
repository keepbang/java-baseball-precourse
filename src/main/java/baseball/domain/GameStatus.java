package baseball.domain;

public enum GameStatus {
    RESTART("1"), END("2"), ERROR("0");

    private String gameStatus;

    GameStatus(String input) {
        this.gameStatus = input;
    }

    public boolean isEnd(){
        return this.equals(END);
    }

    public boolean isNotError() {
        return !this.equals(ERROR);
    }
}
