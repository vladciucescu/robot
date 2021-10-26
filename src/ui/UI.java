package ui;

import domain.Board;
import domain.BoardObject;
import domain.Orientation;
import services.GameService;

import static java.util.stream.Collectors.toList;

public class UI {

    private final GameService service;

    public UI(GameService service) {
        this.service = service;
    }

    public void run() throws InterruptedException {
        while (service.canMoveRobot()) {
            printBoard(service.getBoard(), service.getRobotOrientation());
            service.moveRobot();
            Thread.sleep(1000);
        }
    }

    private void printBoard(Board board, Orientation robotOrientation) {
        var header = "";
        for (int columnIndex = 0; columnIndex < board.getColumnCount(); columnIndex++) {
            var spacing = columnIndex < 9 ? "   " : "  ";
            header += (columnIndex + 1) + spacing;
        }
        var grid = "     " + header;
        for (int rowIndex = 0; rowIndex < board.getRowCount(); rowIndex++) {
            var spacing = rowIndex < 9 ? "  | " : " | ";
            var rowStrings = board.getRow(rowIndex).stream().map(boardObject -> getSymbol(boardObject, robotOrientation)).collect(toList());
            grid += "\n" + (rowIndex + 1) + spacing + String.join(" | ", rowStrings) + " | ";
        }
        System.out.println(grid);
        System.out.println();
    }

    private String getSymbol(BoardObject boardObject, Orientation orientation) {
        return switch (boardObject) {
            case EMPTY -> " ";
            case ROBOT_TRAIL -> ".";
            case ROBOT -> getRobotSymbol(orientation);
        };
    }

    private String getRobotSymbol(Orientation orientation) {
        return switch (orientation) {
            case EAST -> "\u2B9E";
            case NORTH -> "\u2B9D";
            case WEST -> "\u2B9C";
            case SOUTH -> "\u2B9F";
        };
    }
}
