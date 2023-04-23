import java.util.ArrayList;

public class Game {
    Square[][] board = new Square[8][8];
    ArrayList<Piece> whites = new ArrayList<Piece>();
    ArrayList<Piece> blacks = new ArrayList<Piece>();

    public ArrayList<Piece> getWhites() {
        return whites;
    }

    public ArrayList<Piece> getBlacks() {
        return blacks;
    }

    public Square getSquare(int x, int y){
        return board[x][y];
    }


}
