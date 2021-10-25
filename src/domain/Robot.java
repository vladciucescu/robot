package domain;

import static domain.Orientation.EAST;

public class Robot {

    private Orientation orientation;
    private Coordinates position;

    public Robot() {
        orientation = EAST;
        position = new Coordinates(0, 0);
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public Coordinates getPosition() {
        return position;
    }

    public void move(Movement move) {
        orientation = getNextOrientation(move);
        position = getNextPosition(move);
    }

    public Coordinates getNextPosition(Movement move) {
        int nextRow = move.nextRow();
        int nextColumn = move.nextColumn();
        return new Coordinates(position.row() + nextRow, position.column() + nextColumn);
    }

    private Orientation getNextOrientation(Movement move) {
        var newOrientationDegrees = this.orientation.degrees + move.rotationDegrees;
        return Orientation.ofDegrees(newOrientationDegrees);
    }
}
