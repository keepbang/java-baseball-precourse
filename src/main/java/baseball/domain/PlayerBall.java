package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.ValidateUtils.validation;

public class PlayerBall extends Ball{
    public static final int MAX_RANGE = 3;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

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




}
