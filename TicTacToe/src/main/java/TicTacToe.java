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
        if (checkRows(board, last)) return true;
        if (checkColumns(board, last)) return true;
        if (checkPrimaryDiagonal(board, last)) return true;
        return checkSecondaryDiagonal(board, last);
    }

    private static boolean checkSecondaryDiagonal(char[][] board, char last) {
        int count = 0;
        if (board[0][2] == last) count++;
        if (board[1][1] == last) count++;
        if (board[2][0] == last) count++;

        return count == 3;
    }

    private static boolean checkPrimaryDiagonal(char[][] board, char last) {
        int count = 0;
        if (board[0][0] == last) count++;
        if (board[1][1] == last) count++;
        if (board[2][2] == last) count++;

        return count == 3;
    }

    private static boolean checkColumns(char[][] board, char last) {
        for (int i = 0; i < 3; i++) {
            int count = 0;
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

    private static boolean checkRows(char[][] board, char last) {
        for (int i = 0; i < 3; i++) {
            int count = 0;
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

        initializeBoard(board);

        printBoard(board);

        while (true) {
            // Input from 1-9
            int value = getValue(input, board);
            boolean isNextPlayerX = placeTile(board, isX, value);
            printBoard(board);

            if (checkWin(board, isX ? 'X' : 'O')) {
                System.out.println("The Winner is: " + (isX ? 'X' : 'O'));
                break;
            }
            if (checkTie(board)) {
                System.out.println("It's a tie");
                break;
            }
            isX = isNextPlayerX;
        }
    }

    private static boolean placeTile(char[][] board, boolean isX, int value) {
        int count = 1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (value == count) {
                    board[i][j] = isX ? 'X' : 'O';
                    isX = !isX;

                }
                count++;
            }
        }
        return isX;
    }

    private static boolean checkTie(char[][] board) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static int getValue(Scanner input, char[][] board) {
        while (true) {
            try {
                String valueLine = input.nextLine();
                int value = Integer.parseInt(valueLine);
                if (isValid(value, board)) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // Do nothing
            }
            System.out.println("Invalid input");
        }
    }

    private static boolean isValid(int value, char[][] board) {
        if (value <= 0 || value >= 10) {
            return false;
        }

        return board[(value - 1) / 3][(value - 1) % 3] == '-';
    }


}
