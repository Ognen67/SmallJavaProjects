import java.util.Arrays;

public class Board {

    static ChessSquare[][] board = new ChessSquare[8][8];;

    public Board(){

        this.board = new ChessSquare[8][8];

        /* 0 = white pawns
           1 = black pawns
           2 = white rooks
           3 = black rooks
           4 = white knights
           5 = black knights
           6 = white bishop
           7 = black bishop
           8 = white queen
           9 = black queen
           10 = white king
           11 = black king
         */

        int[] pieceAmounts = {8,8,2,2,2,2,2,2,1,1};

        //White pawn setter
        for (int i = 0; i < 8; i++) {
            board[6][i].setPieceOnSquare(new Pawn("white", new int[]{6, i}));
        }

        //Black pawn setter
        for (int i = 0; i < 8; i++) {
            board[1][i] = new ChessSquare(new Pawn("black"), 1);
        }

        //White Pieces

        board[7][0].setPieceOnSquare(new Rook("white", new int[]{7, 0})); // Left white rook
        board[7][7].setPieceOnSquare(new Rook("white", new int[]{7, 7})); // Right white rook
        board[7][1].setPieceOnSquare(new Knight("white", new int[]{7, 1})); // Left white knight
        board[7][6].setPieceOnSquare(new Knight("white", new int[]{7, 6})); // Right white knight
        board[7][2].setPieceOnSquare(new Bishop("white", new int[]{7, 5})); // Left white bishop
        board[7][5].setPieceOnSquare(new Bishop("white", new int[]{7, 2})); // Right white bishop
        board[7][3].setPieceOnSquare(new King("white", new int[]{7, 3})); // White King
        board[7][4].setPieceOnSquare(new Queen("white", new int[]{7, 4})); // White Queen


        //Black Pieces

        board[0][0].setPieceOnSquare(new Rook("black", new int[]{0, 0})); // Left black rook
        board[0][7].setPieceOnSquare(new Rook("black", new int[]{0, 7})); // Right black rook
        board[0][1].setPieceOnSquare(new Knight("black", new int[]{0, 1})); // Left black knight
        board[0][6].setPieceOnSquare(new Knight("black", new int[]{0, 6})); // Right black knight
        board[0][2].setPieceOnSquare(new Bishop("black", new int[]{0, 2})); // Left black bishop
        board[0][5].setPieceOnSquare(new Bishop("black", new int[]{0, 5})); // Right black bishop
        board[0][3].setPieceOnSquare(new King("black", new int[]{0, 3})); // Black King
        board[0][4].setPieceOnSquare(new Queen("black", new int[]{0, 4})); // Black Queen
    }

//    public void movePawn() {
//
//        board[6][1].getPieceOnSquare()
//    }

    public void printBoard() {
        for (ChessSquare[] chessSquares : board) {
            for (ChessSquare chessSquare : chessSquares) {
                if (chessSquare.getPieceOnSquare() != null) {
                    System.out.print(chessSquare.getPieceOnSquare().getPieceValue() + " ");
                } else {
                    System.out.print(chessSquare.getPieceValue() + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Board board = new Board();

        board.printBoard();


    }


}
