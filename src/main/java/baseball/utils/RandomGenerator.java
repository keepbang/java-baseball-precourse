package baseball.utils;

import static baseball.domain.Ball.*;
import static nextstep.utils.Randoms.pickNumberInRange;

public class RandomGenerator {
    public static String getRandomNumbers(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAX_RANGE; i++) {
            sb.append(pickNumberInRange(MIN_VALUE, MAX_VALUE));
        }

        return sb.toString();
    }
}
