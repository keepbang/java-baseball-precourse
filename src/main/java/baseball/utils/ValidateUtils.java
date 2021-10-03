package baseball.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static baseball.domain.PlayerBall.*;

public class ValidateUtils {
    private static final String VALID_REGEX = "["+MIN_VALUE+"-"+MAX_VALUE+"]{"+MAX_RANGE+"}";

    public static void validation(String numbers) {
        if(!numbers.matches(VALID_REGEX)){
            throw new IllegalArgumentException(MAX_RANGE + "자리 숫자를 입력해 주십시오.");
        }
        if(isDuplicateNumbers(numbers)){
            throw new IllegalArgumentException("중복된 숫자가 입력되었습니다.");
        }
    }

    private static boolean isDuplicateNumbers(String numbers){
        Set<String> distinctSet = new HashSet<>(Arrays.asList(numbers.split("")));

        return distinctSet.size() != MAX_RANGE;
    }
}
