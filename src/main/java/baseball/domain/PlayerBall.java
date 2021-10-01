package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerBall extends Ball{
    public static final int MAX_RANGE = 3;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;
    private static final String VALID_REGEX = "["+MIN_VALUE+"-"+MAX_VALUE+"]{"+MAX_RANGE+"}";

    private PlayerBall(List<Integer> numbers) {
        super(numbers);
    }

    public static PlayerBall createPlayerBall(String input) {
        validation(input);
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            numbers.add(Character.getNumericValue(input.charAt(i)));
        }
        return new PlayerBall(numbers);
    }


    private static void validation(String numbers) {
        if(!numbers.matches(VALID_REGEX)){
            throw new IllegalArgumentException("숫자가 잘못 입력되었습니다.");
        }
    }

}
