package config;

import domain.Movement;

import java.util.List;

import static domain.Movement.*;

class MovesParser {

    private static MovesParser instance;

    private MovesParser() {
        if (instance != null) {
            throw new RuntimeException("This class is a singleton!");
        }
        instance = this;
    }

    List<Movement> parseInputs(DriveSystem driveSystem, List<String> inputs) {
        return inputs.stream().map(input -> switch (driveSystem) {
            case SWERVE -> getSwerveMove(input);
            case ARCADE -> getArcadeMove(input);
            case TANK -> getTankMove(input);
            case OMNI -> getOmniMove(input);
        }).toList();
    }

    private Movement getSwerveMove(String input) {
        return switch (input) {
            case "F" -> FORWARD;
            case "B" -> BACKWARD;
            case "L" -> LEFT;
            case "R" -> RIGHT;
            default -> NONE;
        };
    }

    private Movement getArcadeMove(String input) {
        return switch (input) {
            case "F" -> FORWARD;
            case "B" -> BACKWARD;
            case "L" -> TURN_LEFT;
            case "R" -> TURN_RIGHT;
            default -> NONE;
        };
    }

    private Movement getTankMove(String input) {
        if (!input.matches("[FB],[FB]")) {
            return NONE;
        }
        return switch (input) {
            case "F,F" -> FORWARD;
            case "B,B" -> BACKWARD;
            case "F,B" -> ROTATE_RIGHT;
            case "B,F" -> ROTATE_LEFT;
            default -> NONE;
        };
    }

    private Movement getOmniMove(String input) {
        if (!input.matches("[LR]|[FBLR],[FBLR]")) {
            return NONE;
        }
        return switch (input) {
            case "F,F" -> FORWARD;
            case "B,B" -> BACKWARD;
            case "F,B" -> ROTATE_RIGHT;
            case "B,F" -> ROTATE_LEFT;
            case "L" -> TURN_RIGHT;
            case "R" -> TURN_LEFT;
            case "L,L" -> LEFT;
            case "R,R" -> RIGHT;
            default -> NONE;
        };
    }

    public static MovesParser getInstance() {
        if (instance == null) return new MovesParser();
        return instance;
    }
}
