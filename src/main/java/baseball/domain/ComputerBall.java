package baseball.domain;

import static baseball.utils.RandomGenerator.getRandomNumbers;

public class ComputerBall extends Ball{

    public ComputerBall() {
        super(getRandomNumbers());
    }

}
