package services;

import domain.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static domain.BoardObject.ROBOT;
import static domain.BoardObject.ROBOT_TRAIL;

public class GameService {

    private final Board board;
    private final Robot robot;
    private final Queue<Movement> robotMoves;

    public GameService(Board board, Robot robot, List<Movement> robotMoves) {
        this.board = board;
        this.robot = robot;
        this.robotMoves = new LinkedList<>(robotMoves);
        board.setBoardObject(robot.getPosition(), ROBOT);
    }

    public boolean canMoveRobot() {
        return !robotMoves.isEmpty();
    }

    public void moveRobot() {
        var move = robotMoves.poll();
        validateMove(board, robot, move);
        var previousPosition = robot.getPosition();
        robot.move(move);
        board.setBoardObject(previousPosition, ROBOT_TRAIL);
        board.setBoardObject(robot.getPosition(), ROBOT);
    }

    private void validateMove(Board board, Robot robot, Movement move) {
        if (move == null) {
            throw new InvalidMoveException("No more moves!");
        }
        Coordinates nextPosition = robot.getNextPosition(move);
        if (!board.isOnBoard(nextPosition)) {
            throw new InvalidMoveException("Robot hits the wall!");
        }
    }

    public Board getBoard() {
        return board;
    }

    public Orientation getRobotOrientation() {
        return robot.getOrientation();
    }
}
