package baseball.utils;

import baseball.domain.Ball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static baseball.domain.PlayerBall.*;
import static nextstep.utils.Randoms.pickNumberInRange;

public class RandomGenerator{

    public static Ball getRandomPlayerBall(){
        Set<Integer> distinctNumberSet = new HashSet<>();

        while(distinctNumberSet.size() < MAX_RANGE) {
            distinctNumberSet.add(pickNumberInRange(MIN_VALUE, MAX_VALUE));
        }

        return new Ball(new ArrayList<>(distinctNumberSet));
    }

}
