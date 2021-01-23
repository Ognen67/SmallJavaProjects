package com.github.ognen67.gameoflife.mvp;

import java.util.Objects;

public class GameOfLifeModel {


    private boolean[][] board = new boolean[10][10];
    private int rows;
    private int columns;

    public GameOfLifeModel() {
        boolean isBlack = true;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = isBlack;
                isBlack = !isBlack;
            }
            isBlack = !isBlack;
        }
    }

    public boolean[][] getBoard() {
        return board;
    }

    public boolean[][] step() {

        boolean[][] newBoard = new boolean[rows][columns];

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                int aliveNeighbours = countAliveNeighbours(x, y);
                if (getState(x, y) == 1) {
                    if (aliveNeighbours < 2) {
                        newBoard[x][y] = false;
                    } else if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                        newBoard[x][y] = true;
                    } else if (aliveNeighbours > 3) {
                        newBoard[x][y] = false;
                    }
                } else {
                    if (aliveNeighbours == 3) {
                        newBoard[x][y] = true;
                    }
                }
            }
        }
        board = newBoard;
        return board;
    }

    public int countAliveNeighbours(int x, int y) {
        int count = 0;

        count += getState(x - 1, y - 1);
        count += getState(x, y - 1);
        count += getState(x + 1, y - 1);

        count += getState(x - 1, y);
        count += getState(x + 1, y);

        count += getState(x - 1, y + 1);
        count += getState(x, y + 1);
        count += getState(x + 1, y + 1);

        return count;
    }

    public int getState(int x, int y) {
        if (x < 0 || x >= rows) {
            return 0;
        }
        if (y < 0 || y >= columns) {
            return 0;
        }
        if (board[x][y]) {
            return 1;
        }
        return 0;
    }

    public boolean[][] flipTile(int i, int j) {
        Objects.checkIndex(i, rows);
        Objects.checkIndex(j, columns);
        board[i][j] = !board[i][j];
        return board;
    }

    @Deprecated
    public int getSize() {
        return 10;
    }

    public void resizeBoard(int rows, int columns) {
        if (this.rows == rows && this.columns == columns) {
            return;
        }
        this.rows = rows;
        this.columns = columns;

        boolean[][] newBoard = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newBoard[i][j] = getNextValue(i, j);
            }
        }
        board = newBoard;
    }

    private boolean getNextValue(int i, int j) {
        if (i < board.length) {
            boolean[] rowI = board[i];
            if (j < rowI.length) {
                return rowI[j];
            }
        }
        return false;
    }
}
