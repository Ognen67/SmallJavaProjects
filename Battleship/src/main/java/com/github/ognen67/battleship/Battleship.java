package com.github.ognen67.battleship;

import java.util.Scanner;

public class Battleship {

    static int numOfTiles = 8;

    public static void main(String[] args) {

        int[][] board1 = new int[numOfTiles][numOfTiles];
        int[][] board2 = new int[numOfTiles][numOfTiles];
        char[][] charBoard1 = new char[numOfTiles][numOfTiles];
        char[][] charBoard2 = new char[numOfTiles][numOfTiles];
        boolean isPlayerOne = true;
        Scanner input = new Scanner(System.in);
        int i, j;

        initializeBoard(board1);
        initializeBoard(board2);
        printBoard(board1);

        initializeCharBoard(charBoard1);
        printCharBoard(charBoard1);


        while (!gameEnded(board1, board2)) {
            System.out.println("Enter coordinates to sink a ship!");
            i = input.nextInt();
            j = input.nextInt();
            if (!attack(i, j, board1, board2, isPlayerOne)) {
                isPlayerOne = !isPlayerOne;
                System.out.println(isPlayerOne ? "Player 2's board" : "Player 1's board");
                printBoard(isPlayerOne ? board2 : board1);
            } else {
                System.out.println(isPlayerOne ? "Player 2's board" : "Player 1's board");
                printBoard(isPlayerOne ? board2 : board1);
            }
            checkWinnder(board1, board2);
        }
    }

    private static void initializeBoard(int[][] board) {
        board[0][5] = 1;
        board[1][5] = 1;
        board[2][5] = 1;

//        board[3][0] = 1;
//        board[3][1] = 1;
//        board[3][2] = 1;
//        board[3][3] = 1;
//
//        board[5][5] = 1;
//        board[6][5] = 1;
//
//        board[7][3] = 1;
//        board[7][4] = 1;
//        board[7][5] = 1;
//        board[7][6] = 1;
    }

    private static void initializeCharBoard(char[][] charBoard) {
        for (int i = 0; i < numOfTiles; i++) {
            for (int j = 0; j < numOfTiles; j++) {
                charBoard[i][j] = '-';
            }
            System.out.println();
        }
    }

    private static void printBoard(int[][] board1) {
        for (int i = 0; i < numOfTiles; i++) {
            for (int j = 0; j < numOfTiles; j++) {
                System.out.print(board1[i][j]);
            }
            System.out.println();
        }
    }

    private static void printCharBoard(char[][] charBoard) {
        for (int i = 0; i < numOfTiles; i++) {
            for (int j = 0; j < numOfTiles; j++) {
                System.out.print(charBoard[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean attack(int i, int j, int[][] board1, int[][] board2, boolean isPlayerOne) {
        if (isPlayerOne) {
            if (board2[i][j] == 1) {
                System.out.println("HIT");
                board2[i][j] = 0;
                return true;
            } else {
                System.out.println("MISS");
                return false;
            }
        } else {
            if (board1[i][j] == 1) {
                System.out.println("HIT");
                board1[i][j] = 0;
                return true;
            } else {
                System.out.println("MISS");
                return false;
            }
        }
    }

    private static boolean isBoardEmpty(int[][] board) {
        for (int i = 0; i < numOfTiles; i++) {
            for (int j = 0; j < numOfTiles; j++) {
                if (board[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean gameEnded(int[][] board1, int[][] board2) {
        return isBoardEmpty(board1) || isBoardEmpty(board2);
    }

    private static void checkWinnder(int[][] board1, int[][] board2) {
        if(gameEnded(board1, board2)) {
            if (isBoardEmpty(board1)) {
                System.out.println("The Winner is Player 2");
            } else {
                System.out.println("The Winner is Player 1");
            }
        }
    }

}
