package com.github.ognen67.gameoflife.mvp;

import java.util.Objects;

public class GameOfLifeModel {

	public static final int BOARD_SIZE = 150;
	private boolean[][] board = new boolean[BOARD_SIZE][BOARD_SIZE];

	public GameOfLifeModel() {
		boolean isBlack = true;
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
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

		boolean[][] newBoard = new boolean[BOARD_SIZE][BOARD_SIZE];

		for (int x = 0; x < BOARD_SIZE; x++) {
			for (int y = 0; y < BOARD_SIZE; y++) {
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
		if (x < 0 || x >= BOARD_SIZE) {
			return 0;
		}
		if (y < 0 || y >= BOARD_SIZE) {
			return 0;
		}
		if (board[x][y]) {
			return 1;
		}
		return 0;
	}

	public boolean[][] flipTile(int i, int j) {
		Objects.checkIndex(i, BOARD_SIZE);
		Objects.checkIndex(j, BOARD_SIZE);
		board[i][j] = !board[i][j];
		return board;
	}

	public int getSize() {
		return BOARD_SIZE;
	}
}
