package com.github.ognen67.battleship.oop;

import java.util.Scanner;

public class BattleshipGame {

    private final Board board1;
    private final Board board2;
    int currentPlayer = 1;

    public static void main(String[] args) {
        BattleshipGame battleshipGame = new BattleshipGame(8);
        battleshipGame.play();
    }

    public BattleshipGame(int numOfTiles) {
        board1 = new Board(numOfTiles);
        board2 = new Board(numOfTiles);
        board1.initializeBoard();
        board2.initializeBoard();
    }

    private void play() {
        Scanner input = new Scanner(System.in);
        while (!gameEnds()) {
            Board board = getCurrentPlayerBoard();
            printBoardInfo(board);
            currentPlayer = shootBullet(input, board);
        }
        checkWinner();
    }

    private Board getCurrentPlayerBoard() {
        return currentPlayer == 1 ? board2 : board1;
    }

    private int shootBullet(Scanner input, Board board) {
        System.out.println("Enter coordinates to sink a ship!");
        if (!board.checkShip(input.nextInt(), input.nextInt())) {
            return currentPlayer == 2 ? 1 : 2;
        }
        return currentPlayer;
    }

    private void printBoardInfo(Board board) {
        System.out.printf("Player %d's board%n", currentPlayer);
        System.out.println("Remaining ships: " + board.numOfShips());
        System.out.println(board.toString());
    }

    private boolean gameEnds() {
        return board1.isEmpty() || board2.isEmpty();
    }

    private void checkWinner() {
        if (gameEnds()) {
            if (board1.isEmpty()) {
                System.out.println("The Winner is Player 2");
            } else {
                System.out.println("The Winner is Player 1");
            }
        }
    }
}
