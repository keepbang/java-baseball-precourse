package baseball.domain;

public class Ball {
    public static final int MAX_RANGE = 3;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    private static final String VALID_REGEX = "^["+MIN_VALUE+"-"+MAX_VALUE+"]{"+MAX_RANGE+"}";

    private String[] ballNumbers;

    public Ball(String numbers) {
        validation(numbers);
        this.ballNumbers = numbers.split("");
    }

    private void validation(String numbers) {
        if(!numbers.matches(VALID_REGEX)){
            throw new IllegalArgumentException("숫자가 잘못 입력되었습니다.");
        }
    }
}
