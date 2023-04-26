import java.awt.*;
import java.util.ArrayList;

public class Piece {

    private String color;
    private boolean isAlive;
    private Image image;
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    public boolean isAlive() {
        return isAlive;
    }
    public Piece(String color){
        isAlive = true;
        this.color = color;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ArrayList<Square> getValidMoves(Board board, Square loc){
        ArrayList<Square> arr = new ArrayList<Square>();

        return arr;
    }

    public boolean isValidMove(Board board, Square loc, Square dest)
    {
        if(loc.getPiece().getColor().equals(
                dest.getPiece().getColor())){
            return false;
        }
        ArrayList<Square> possiblemoves = this.getValidMoves(board, loc);
        for (Square possiblemove : possiblemoves) {
            if (possiblemove.equals(dest)) {
                break;
            }
            return false;
        }
        //Need to make the move hypothetically first
        Board future = new Board(board.getBoard());
        future.getSquare(dest.getX(), dest.getY()).setPiece(loc.getPiece());
        future.getSquare(loc.getX(), loc.getY()).setPiece(null);
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (!this.getColor().equals(board.getSquare(i,j).getPiece().getColor())){
                    ArrayList<Square> attacking = board.getSquare(i,j).getPiece().getValidMoves(board, board.getSquare(i,j));
                    for (Square s : attacking){
                        if (s.equals(king_position)){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }



}
