import config.SettingsReader;
import domain.Board;
import domain.Movement;
import domain.Robot;
import services.GameService;
import ui.UI;

import java.util.List;

public class Game {

    public static void main(String... args) throws InterruptedException {
        var board = new Board();
        var robot = new Robot();
        var gameService = new GameService(board, robot, getRobotMoves());
        var ui = new UI(gameService);
        ui.run();
    }

    private static List<Movement> getRobotMoves() {
        return SettingsReader.getInstance()
                .readSettings()
                .orElseThrow(() -> new RuntimeException("Cannot get robot moves"));
    }
}
