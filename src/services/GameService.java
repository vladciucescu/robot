package services;

import domain.Board;
import domain.Coordinates;
import domain.Movement;
import domain.Robot;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static domain.BoardObject.SNAKE_SEGMENT;

public class GameService {

    private final Board board;
    private final Robot robot;
    private final Queue<Movement> robotMoves;

    public GameService(Board board, Robot robot, List<Movement> robotMoves) {
        this.board = board;
        this.robot = robot;
        this.robotMoves = new LinkedList<>(robotMoves);
    }

    public boolean canMoveRobot() {
        return !robotMoves.isEmpty();
    }

    public void moveRobot() {
        var move = robotMoves.poll();
        validateMove(board, robot, move);
        robot.move(move);
        board.updateRobotPosition(robot);
    }

    private void validateMove(Board board, Robot robot, Movement move) {
        if (move == null) {
            throw new InvalidMoveException("No more moves!");
        }
        Coordinates nextPosition = robot.getNextPosition(move);
        if (!board.isOnBoard(nextPosition)) {
            throw new InvalidMoveException("Snake hits the wall!");
        }
    }
}
