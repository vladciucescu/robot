package ui;

import services.GameService;

public class UI {

    private final GameService service;

    public UI(GameService service) {
        this.service = service;
    }

    public void run() throws InterruptedException {
        while (service.canMoveRobot()) {
            printBoard();
            service.moveRobot();
            Thread.sleep(1000);
        }
    }

    private void printBoard() {

    }
}
