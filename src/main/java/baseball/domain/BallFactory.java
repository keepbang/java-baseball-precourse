package baseball.domain;

public class BallFactory {
    private BallFactory(){};

    public static Ball create(String numbers){
        return new Ball(numbers);
    }

}
