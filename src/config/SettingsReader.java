package config;

import domain.DriveSystem;
import domain.Movement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SettingsReader {

    private static final String SETTINGS_FILE = "robot.settings";

    private static SettingsReader instance;

    private SettingsReader() {
        if (instance != null) {
            throw new RuntimeException("This class is a singleton!");
        }
        instance = this;
    }

    public Optional<RobotSettings> readSettings() {
        try {
            List<String> lines = Files.readAllLines(Path.of(SETTINGS_FILE));
            if (lines.isEmpty()) {
                System.out.println("Robot settings file is empty.");
                return Optional.empty();
            }
            var driveSystem = DriveSystem.valueOf(lines.get(0));
            var moves = getMoves(driveSystem, lines.subList(1, lines.size()));
            var settings = new RobotSettings(driveSystem, moves);
            return Optional.of(settings);
        } catch (IOException e) {
            System.out.println("Cannot read robot settings file.");
        }
        return Optional.empty();
    }

    private List<Movement> getMoves(DriveSystem driveSystem, List<String> inputs) {
        return Collections.emptyList();
    }

    public static SettingsReader getInstance() {
        if (instance == null) return new SettingsReader();
        return instance;
    }
}
