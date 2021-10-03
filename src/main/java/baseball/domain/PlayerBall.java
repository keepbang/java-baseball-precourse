package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.ValidateUtils.validation;

public class PlayerBall extends Ball{
    public static final int MAX_RANGE = 3;

    private PlayerBall(List<Integer> numbers) {
        super(numbers);
    }

    public static PlayerBall createPlayerBall(String input) {
        validation(input);
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < MAX_RANGE; i++) {
            numbers.add(Character.getNumericValue(input.charAt(i)));
        }
        return new PlayerBall(numbers);
    }




}
