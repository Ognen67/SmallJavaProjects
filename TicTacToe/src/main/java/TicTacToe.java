import java.util.Scanner;

public class TicTacToe {

    private static void printBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static boolean checkWin(char[][] board, char last) {
        int count = 0;
        if (checkRows(board, last, count)) return true;
        count = 0;
        if (checkColumns(board, last, count)) return true;
        count = 0;
        if (checkPrimaryDiagonal(board, last, count)) return true;
        count = 0;
        if (checkSecondaryDiagonal(board, last, count)) return true;

        return false;
    }

    private static boolean checkSecondaryDiagonal(char[][] board, char last, int count) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i + j == 4) {
                    if (board[i][0] == last) {
                        count++;
                        if (count == 3) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkPrimaryDiagonal(char[][] board, char last, int count) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    if (board[i][0] == last) {
                        count++;
                        if (count == 3) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkColumns(char[][] board, char last, int count) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == last) {
                    count++;
                    if (count == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkRows(char[][] board, char last, int count) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == last) {
                    count++;
                    if (count == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        char board[][] = new char[3][3];
        Scanner input = new Scanner(System.in);
        boolean isX = true;
        int value;
        int count = 1;

        initializeBoard(board);

        printBoard(board);

        while (true) {
            // Input from 1-9
            value = input.nextInt();

            if (isValid(value)) {
                count = 1;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (value == count) {
                            board[i][j] = isX ? 'X' : 'O';
                            isX = !isX;
                            if (checkWin(board, board[i][j])) {
                                System.out.println("The Winner is: " + board[i][j]);
                            }
                        }
                        count++;

                    }
                }
            } else {
                System.out.println("Invalid input");
            }

            printBoard(board);
        }
    }

    private static boolean isValid(int value) {
        return value > 0 && value < 10;
    }


}
