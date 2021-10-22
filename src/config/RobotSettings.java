package config;

import domain.DriveSystem;
import domain.Movement;

import java.util.List;

public record RobotSettings(DriveSystem driveSystem, List<Movement> moves) {
}
