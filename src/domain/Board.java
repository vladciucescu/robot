package domain;

import java.util.List;

import static domain.BoardObject.*;

public class Board {

    private final BoardObject[][] board;
    private final int rows;
    private final int columns;

    public Board() {
        rows = 5;
        columns = 5;
        board = createBoard(rows, columns);
    }

    private BoardObject[][] createBoard(int numberOfRows, int numberOfColumns) {
        var board = new BoardObject[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                board[i][j] = EMPTY;
            }
        }
        return board;
    }

    public int getRowCount() {
        return rows;
    }

    public int getColumnCount() {
        return columns;
    }

    public void setBoardObject(Coordinates coordinates, BoardObject boardObject) {
        board[coordinates.row()][coordinates.column()] = boardObject;
    }

    public BoardObject getBoardObject(Coordinates coordinates) {
        return board[coordinates.row()][coordinates.column()];
    }

    public List<BoardObject> getRow(int rowIndex) {
        return List.of(board[rowIndex]);
    }

    public boolean isOnBoard(Coordinates coordinates) {
        int row = coordinates.row();
        int column = coordinates.column();
        return 0 <= row && row < rows && 0 <= column && column < columns;
    }
}
