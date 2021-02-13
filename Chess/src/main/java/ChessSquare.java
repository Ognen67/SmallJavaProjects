public class ChessSquare {

    private String color;

    /* Piece value is as follows:

    No piece: 0 or -1
    Pawn: 1 point (or pawn)
    Knight: 3 points
    Bishop: 3 points
    Rook: 5 points
    Queen: 9 points

     */

    private Piece pieceOnSquare;
    private int pieceValue;

    public ChessSquare() {
        this.pieceValue = -1;
    }

    public ChessSquare(String myColor){

        this.color = myColor;
        this.pieceValue = -1;
    }

    public ChessSquare(String myColor, int myValue){

        this.color = myColor;
        this.pieceValue = myValue;

    }

    public ChessSquare(Piece pieceOnSquare, int pieceValue) {
        this.pieceOnSquare = pieceOnSquare;
        this.pieceValue = pieceValue;
    }

    public ChessSquare(String color, Piece pieceOnSquare, int pieceValue) {
        this.color = color;
        this.pieceOnSquare = pieceOnSquare;
        this.pieceValue = pieceValue;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPieceValue() {
        return pieceValue;
    }

    public void setPieceValue(int pieceValue) {
        this.pieceValue = pieceValue;
    }
}
