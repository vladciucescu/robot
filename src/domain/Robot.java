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
        logMove(move);
        orientation = getNextOrientation(move);
        position = getNextPosition(move);
    }

    private void logMove(Movement move) {
        System.out.printf("Moving %s facing robot from position (%d,%d): %s\n", orientation, position.row()+1, position.column()+1, move);
    }

    public Coordinates getNextPosition(Movement move) {
        int rowIndex = move.rowIndex(orientation);
        int columnIndex = move.columnIndex(orientation);
        return new Coordinates(position.row() + rowIndex, position.column() + columnIndex);
    }

    private Orientation getNextOrientation(Movement move) {
        var newOrientationDegrees = this.orientation.degrees + move.rotationDegrees;
        return Orientation.ofDegrees(newOrientationDegrees);
    }
}
