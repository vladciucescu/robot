package domain;

import static domain.Direction.RIGHT;

public class Robot {

    private Direction direction;
    private Coordinates position;

    public Robot() {
        direction = RIGHT;
        position = new Coordinates(0, 0);
    }
}
