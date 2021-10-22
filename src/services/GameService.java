package services;

import domain.Board;
import domain.Robot;

public class GameService {

    private final Robot robot;
    private final Board board;

    public GameService(Robot robot, Board board) {
        this.robot = robot;
        this.board = board;
    }
}
