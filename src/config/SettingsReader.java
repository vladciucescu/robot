package config;

import domain.Movement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

    public Optional<List<Movement>> readSettings() {
        try {
            List<String> lines = Files.readAllLines(Path.of(SETTINGS_FILE));
            if (lines.isEmpty()) {
                System.out.println("Robot settings file is empty.");
                return Optional.empty();
            }
            var driveSystem = DriveSystem.valueOf(lines.get(0));
            var movesParser = MovesParser.getInstance();
            var moves = movesParser.parseInputs(driveSystem, lines.subList(1, lines.size()));
            return Optional.of(moves);
        } catch (IOException e) {
            System.out.println("Cannot read robot settings file.");
        } catch (IllegalArgumentException e) {
            System.out.println("Unknown drive system");
        }
        return Optional.empty();
    }

    public static SettingsReader getInstance() {
        if (instance == null) return new SettingsReader();
        return instance;
    }
}
