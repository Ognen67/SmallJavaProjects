public class Pawn extends Piece {

    public Pawn(String myPieceColor){
        this.pieceColor = myPieceColor;

        if(pieceColor.equals("white")){


        }
        else{

        }

    }

    public int[] movePiece() {
        if(this.pieceColor.equals("white")) {
            if(Board.board[position[0]][position[1]+1].getPieceValue() == 0){
                this.position[1]++;

                Board.board[position[0]][position[1]].setPieceOnSquare(this);
                Board.board[position[0]][position[1]-1].removePiece();
            }
        }

        return new int[0];
    }

    public int[][] eatEnemyPiece() {


        return new int[0][];
    }

}
