package com.github.ognen67.battleship.oop;

import java.nio.CharBuffer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Board {
    char[][] board;
    private final int numOfTiles;

    public Board(int numOfTiles) {
        board = new char[numOfTiles][numOfTiles];
        this.numOfTiles = numOfTiles;
        for (int i = 0; i < numOfTiles; i++) {
            for (int j = 0; j < numOfTiles; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void initializeBoard() {
        setShip(0, 5);
        setShip(1, 5);
        setShip(2, 5);
        setShip(3, 0);
        setShip(3, 1);
        setShip(3, 2);
        setShip(3, 3);
    }

    private void setShip(int i, int j) {
        board[i][j] = 's';
    }

    @Override
    public String toString() {
        return Stream.of(board).map(this::formatRow).collect(Collectors.joining("\n"));
    }

    private String formatRow(char[] row) {
        return buildStream(row).map(c -> c == 's' ? '-' : c).map(Object::toString).collect(Collectors.joining(""));
    }

    private Stream<Character> buildStream(char[] row) {
        return CharBuffer.wrap(row).chars().mapToObj(ch -> (char) ch);

    }

    int numOfShips() {
        int numOfShips = 0;
        for (int i = 0; i < numOfTiles; i++) {
            for (int j = 0; j < numOfTiles; j++) {
                if (board[i][j] == 's') {
                    numOfShips++;
                }
            }
        }
        return numOfShips;
    }

    public boolean isEmpty() {
        for (int i = 0; i < numOfTiles; i++) {
            for (int j = 0; j < numOfTiles; j++) {
                if (board[i][j] == 's') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkShip(int i, int j) {
        if (board[i][j] == 's') {
            System.out.println("HIT");
            board[i][j] = 'X';
            return true;
        } else {
            System.out.println("MISS");
            board[i][j] = 'O';
            return false;
        }
    }
}

