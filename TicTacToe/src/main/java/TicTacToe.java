import java.util.Scanner;

public class TicTacToe {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        char board[][] = new char[3][3];
        boolean isX = true;
        int value;
        int count=1;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                board[i][j] = '-';
            }
        }

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        while(true)
        {
            // Input from 1-9
            value = input.nextInt();

            if(value > 0 && value < 10) {
                count = 0;
                for(int i=0; i<3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(value == count) {
                        board[i][j] = 'X';
                    }
                    count++;
                }
            }
            }
            else {
                System.out.println("Invalid input");
            }

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        }
    }
}
