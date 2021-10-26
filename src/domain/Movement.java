package domain;

public enum Movement {
    FORWARD(1,0, 0),
    BACKWARD(-1,0, 0),
    LEFT(0,-1, 0),
    RIGHT(0,1, 0),
    TURN_LEFT(1,-1, -90),
    TURN_RIGHT(1,1, 90),
    ROTATE_LEFT(0,0, -90),
    ROTATE_RIGHT(0,0, 90),
    NONE(0,0, 0);

    private final int rowIndex;
    private final int columnIndex;
    final int rotationDegrees;

    Movement(int rowIndex, int columnIndex, int rotationDegrees) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.rotationDegrees = rotationDegrees;
    }

    // https://en.wikipedia.org/wiki/Rotation_matrix#In_two_dimensions
    int rowIndex(Orientation orientation) {
        double radians = Math.toRadians(orientation.degrees);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        return (int)Math.round(rowIndex * sin + columnIndex * cos);
    }

    int columnIndex(Orientation orientation) {
        double radians = Math.toRadians(orientation.degrees);
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        return (int)Math.round(rowIndex * cos - columnIndex * sin);
    }
}
