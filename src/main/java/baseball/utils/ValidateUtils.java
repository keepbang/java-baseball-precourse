package baseball.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static baseball.domain.PlayerBall.*;

public class ValidateUtils {
    private static final String VALID_REGEX = "[1-9]{"+MAX_RANGE+"}";

    public static void validation(String numbers) {
        if(!numbers.matches(VALID_REGEX)){
            throw new IllegalArgumentException("1부터 9까지의 숫자 "+MAX_RANGE+"자리를 입력해주세요.");
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
