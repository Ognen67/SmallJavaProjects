public class Board {

    ChessSquare[][] board;

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

        for (int i = 0; i < 8; i++){

            board[6][i] = new ChessSquare(new Pawn("white"), 1);
            
        }
        
        //Black pawn setter

        for (int i = 0; i < 8; i++) {
            board[1][i] = new ChessSquare(new Pawn("black"), 1);
        }

        // Set the board colors
        boolean isWhite = true; 
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(isWhite) {

                    board[i][j] = new ChessSquare("white");
                }
                else{
                    board[i][j] = new ChessSquare("black");

                }
                isWhite = !isWhite;
            }
            isWhite = !isWhite;
        }
    }

    private void printBoard() {
        for (ChessSquare[] chessSquares : board) {
            for (ChessSquare chessSquare : chessSquares) {
                System.out.print(chessSquare.getPieceValue() + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Board board = new Board();

        board.printBoard();



    }



}
