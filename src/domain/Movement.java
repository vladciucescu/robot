package domain;

public enum Movement {
    FORWARD(1,0),
    BACKWARD(-1,0),
    LEFT(0,-1),
    RIGHT(0,1),
    TURN_RIGHT(1,-1),
    TURN_LEFT(1,1),
    ROTATE_RIGHT(0,0),
    ROTATE_LEFT(0,0),
    NONE(0,0);

    private final int rowIndex;
    private final int columnIndex;

    Movement(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    int nextRow(Direction direction) {
        return rotateX(rowIndex, columnIndex, direction);
    }

    int nextColumn(Direction direction) {
        return rotateY(rowIndex, columnIndex, direction);
    }

    // https://en.wikipedia.org/wiki/Rotation_matrix
    private int rotateX(int x, int y, Direction direction) {
        var radians = Math.toRadians(direction.rotationDegrees);
        var sin = Math.sin(radians);
        var cos = Math.cos(radians);
        return (int)(x * cos - y * sin);
    }

    private int rotateY(int x, int y, Direction direction) {
        var radians = Math.toRadians(direction.rotationDegrees);
        var sin = Math.sin(radians);
        var cos = Math.cos(radians);
        return (int)(x * cos + y * sin);
    }
}
