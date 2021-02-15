public class Piece {

    protected int[] position = {-1, -1};
    protected String pieceColor = "";
    protected int pieceValue = 0;

    public Piece(String pieceColor, int[] piecePosition){
        this.pieceColor = pieceColor;
        this.position = piecePosition;
    }


    public int getPieceValue(){

        return pieceValue;
    }


//    public int[] movePiece(){
//
//    }
//
//    public int[][] eatEnemyPiece(){
//
//    }


}