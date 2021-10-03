package baseball.utils;

import baseball.domain.Ball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import static baseball.domain.PlayerBall.*;
import static nextstep.utils.Randoms.pickNumberInRange;

public class RandomGenerator{

    public static Ball getRandomPlayerBall(){
        Set<Integer> distinctNumberSet = new LinkedHashSet<>();

        while(distinctNumberSet.size() < MAX_RANGE) {
            distinctNumberSet.add(pickNumberInRange(1, 9));
        }

        return new Ball(new ArrayList<>(distinctNumberSet));
    }

}
