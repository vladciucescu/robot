package services;

import domain.Board;
import domain.Movement;
import domain.Robot;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    }
}
