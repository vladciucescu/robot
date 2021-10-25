package domain;

public enum Direction {
    UP(0),
    DOWN(180),
    LEFT(-90),
    RIGHT(90);

    public final double rotationDegrees;

    Direction(double rotationDegrees) {
        this.rotationDegrees = rotationDegrees;
    }
}
