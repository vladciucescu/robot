package domain;

public enum Orientation {
    EAST(0),
    NORTH(90),
    WEST(180),
    SOUTH(270);

    final int degrees;

    Orientation(int degrees) {
        this.degrees = degrees;
    }

    public static Orientation ofDegrees(int newOrientationDegrees) {
        return switch (newOrientationDegrees % 360) {
            case 0 -> EAST;
            case 90 -> NORTH;
            case 180 -> WEST;
            case 270 -> SOUTH;
            default -> throw new IllegalArgumentException("Invalid orientation degrees: " + newOrientationDegrees);
        };
    }
}
