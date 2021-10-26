package domain;

import java.util.Arrays;

// rotation direction is clockwise
// https://en.wikipedia.org/wiki/Rotation_matrix#Non-standard_orientation_of_the_coordinate_system
public enum Orientation {
    EAST(0),
    NORTH(-90),
    WEST(180),
    SOUTH(90);

    final int degrees;

    Orientation(int degrees) {
        this.degrees = degrees;
    }

    public static Orientation ofDegrees(int newOrientationDegrees) {
        return switch (newOrientationDegrees % 360) {
            case 0 -> EAST;
            case -90 -> NORTH;
            case 180, -180 -> WEST;
            case 90 -> SOUTH;
            default -> throw new IllegalArgumentException("Invalid orientation degrees: " + newOrientationDegrees);
        };
    }
}
