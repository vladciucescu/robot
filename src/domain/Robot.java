package domain;

import static domain.Direction.RIGHT;

public class Robot {

    private Direction direction;
    private Coordinates position;

    public Robot() {
        direction = RIGHT;
        position = new Coordinates(0, 0);
    }

    public void move(Movement move) {
        position = getNextPosition(move);
    }

    public Coordinates getNextPosition(Movement move) {
        int nextRow = move.nextRow(direction);
        int nextColumn = move.nextColumn(direction);
        return new Coordinates(position.row() + nextRow, position.column() + nextColumn);
    }
}
