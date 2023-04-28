public class Square {
    private int x;
    private int y;
    private Piece piece;

    public Square(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(Square other){
        if (this.x == other.getX() && this.y == other.getY()){
            return true;
        }
        return false;
    }

    public boolean hasPiece(){
        if (this.getPiece() == null){
            return false;
        }
        return true;
    }
}
