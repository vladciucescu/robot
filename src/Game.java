import domain.RobotSettings;
import config.SettingsReader;
import domain.Board;
import domain.Robot;
import services.GameService;
import ui.UI;

public class Game {

    public static void main(String... args) {
        var robot = new Robot(getRobotSettings());
        var board = new Board();
        var gameService = new GameService(robot, board);
        var ui = new UI(gameService);
        ui.run();
    }

    private static RobotSettings getRobotSettings() {
        return SettingsReader.getInstance()
                .readSettings()
                .orElseThrow(() -> new RuntimeException("Cannot read robot settings"));
    }
}
