package domain;

public enum Movement {
    FORWARD(1,0, 0),
    BACKWARD(-1,0, 0),
    LEFT(0,-1, 0),
    RIGHT(0,1, 0),
    TURN_RIGHT(1,-1, -90),
    TURN_LEFT(1,1, 90),
    ROTATE_RIGHT(0,0, -90),
    ROTATE_LEFT(0,0, 90),
    NONE(0,0, 0);

    private final int rowIndex;
    private final int columnIndex;
    final int rotationDegrees;

    Movement(int rowIndex, int columnIndex, int rotationDegrees) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.rotationDegrees = rotationDegrees;
    }

    // https://en.wikipedia.org/wiki/Rotation_matrix
    int rowIndex(Orientation orientation) {
        var sin = Math.sin(orientation.degrees);
        var cos = Math.cos(orientation.degrees);
        return (int)(rowIndex * sin + columnIndex * cos);
    }

    int columnIndex(Orientation orientation) {
        var sin = Math.sin(orientation.degrees);
        var cos = Math.cos(orientation.degrees);
        return (int)(rowIndex * cos - columnIndex * sin);
    }
}
