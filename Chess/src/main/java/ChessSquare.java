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

    public ChessSquare(String color) {
        this.color = color;
        this.pieceValue = 0;
    }

    public ChessSquare(Piece pieceOnSquare) {
        this.pieceOnSquare = pieceOnSquare;
        this.pieceValue = pieceValue;
    }

    public ChessSquare(String color, Piece pieceOnSquare) {
        this.color = color;
        this.pieceOnSquare = pieceOnSquare;
        this.pieceValue = pieceOnSquare.getPieceValue();
    }

    @Override
    public String toString() {
        return "pieceValue=" + pieceValue +
                '}';
    }

    public Piece getPieceOnSquare() {
        return pieceOnSquare;
    }

    public void setPieceOnSquare(Piece pieceOnSquare) {
        this.pieceOnSquare = pieceOnSquare;
    }

    public void removePiece(){
        this.pieceOnSquare = null;
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
