package com.github.ognen67.battleship;

import java.util.Scanner;

public class BattleshipChar {

    static int numOfTiles = 8;

    public static void main(String[] args) {

        char[][] board1 = new char[numOfTiles][numOfTiles];
        char[][] board2 = new char[numOfTiles][numOfTiles];
        boolean isPlayerOne = true;
        Scanner input = new Scanner(System.in);
        int i, j;

        createBoard(board1);
        createBoard(board2);
        initializeBoard(board1);
        initializeBoard(board2);
        printBoard(board2);

        while (!gameEnds(board1, board2)) {
            System.out.println("Enter coordinates to sink a ship!");
            i = input.nextInt();
            j = input.nextInt();
            if (!isHit(i, j, board1, board2, isPlayerOne)) {
                isPlayerOne = !isPlayerOne;
                printBoardInfo(board1, board2, isPlayerOne);
            } else {
                printBoardInfo(board1, board2, isPlayerOne);
            }
            checkWinner(board1, board2);
        }
    }

    private static void printBoardInfo(char[][] board1, char[][] board2, boolean isPlayerOne) {
        System.out.println(isPlayerOne ? "Player 2's board" : "Player 1's board");
        printRemainingShips(isPlayerOne ? board2 : board1);
        printBoard(isPlayerOne ? board2 : board1);
    }

    private static int numOfShips(char[][] board) {
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

    private static void initializeBoard(char[][] board) {
        setShip(board, 0, 5);
        setShip(board, 1, 5);
        setShip(board, 2, 5);

        setShip(board, 3, 0);
        setShip(board, 3, 1);
        setShip(board, 3, 2);
        setShip(board, 3, 3);
    }

    private static void setShip(char[][] board, int i, int j) {
        board[i][j] = 's';
    }


    private static void createBoard(char[][] charBoard) {
        for (int i = 0; i < numOfTiles; i++) {
            for (int j = 0; j < numOfTiles; j++) {
                charBoard[i][j] = '-';
            }
            System.out.println();
        }
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < numOfTiles; i++) {
            for (int j = 0; j < numOfTiles; j++) {
                if (board[i][j] == 's') {
                    System.out.print('-');
                } else {
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static boolean isHit(int i, int j, char[][] board1, char[][] board2, boolean isPlayerOne) {
        if (isPlayerOne) {
            return checkShip(i, j, board2);
        } else {
            return checkShip(i, j, board1);
        }
    }

    private static boolean checkShip(int i, int j, char[][] board1) {
        if (board1[i][j] == 's') {
            System.out.println("HIT");
            board1[i][j] = 'X';
            return true;
        } else {
            System.out.println("MISS");
            board1[i][j] = 'O';
            return false;
        }
    }

    private static void printRemainingShips(char[][] board) {
        System.out.println("Remaining ships: " + numOfShips(board));
    }

    private static boolean isBoardEmpty(char[][] board) {
        for (int i = 0; i < numOfTiles; i++) {
            for (int j = 0; j < numOfTiles; j++) {
                if (board[i][j] == 's') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean gameEnds(char[][] board1, char[][] board2) {
        return isBoardEmpty(board1) || isBoardEmpty(board2);
    }

    private static void checkWinner(char[][] board1, char[][] board2) {
        if (gameEnds(board1, board2)) {
            if (isBoardEmpty(board1)) {
                System.out.println("The Winner is Player 2");
            } else {
                System.out.println("The Winner is Player 1");
            }
        }
    }
}
