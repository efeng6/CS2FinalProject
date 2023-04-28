import java.awt.*;
import java.util.ArrayList;

public class Piece {

    private String color;
    private boolean isAlive;
    private Image image;
    private String type;
    private Square king_position;
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public Square getKing_position() {
        return king_position;
    }

    public void setKing_position(Square king_position) {
        this.king_position = king_position;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    public boolean isAlive() {
        return isAlive;
    }
    public Piece(String color, String type){
        isAlive = true;
        this.color = color;
        this.type = type;
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
        if(loc.getX() == dest.getX() && loc.getY() == dest.getY()){
            return false;
        }
        if(dest.getPiece() != null && loc.getPiece().getColor().equals(dest.getPiece().getColor())){
            return false;
        }
        if (dest.getY() > 7 || dest.getY() < 0 || dest.getX() > 7 || dest.getX() < 0){
            return false;
        }
        ArrayList<Square> possiblemoves = this.getValidMoves(board, loc);
        boolean something = true;
        for (Square possiblemove : possiblemoves) {
            if (possiblemove.getX() == dest.getX() && possiblemove.getY() == dest.getY()) {
                something = false;
                break;
            }
        }
        if(something){
            return false;
        }

        //Need to make the move hypothetically first
        Square[][] futureboard = new Square[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                futureboard[i][j] = new Square(i,j,board.getSquare(i,j).getPiece());
            }
        }
        Board future = new Board(futureboard);
        future.getSquare(dest.getX(), dest.getY()).setPiece(loc.getPiece());
        future.getSquare(loc.getX(), loc.getY()).setPiece(null);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (future.getSquare(i,j).getPiece() != null &&
                        future.getSquare(i,j).getPiece().getType().equals("king")&&
                        future.getSquare(i,j).getPiece().getColor().equals(this.getColor())){
                    this.setKing_position(future.getSquare(i,j));
                    break;
                }
            }
        }
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (future.getSquare(i,j).getPiece() != null &&
                !this.getColor().equals(future.getSquare(i,j).getPiece().getColor())){
                    ArrayList<Square> attacking = future.getSquare(i,j).getPiece().getValidMoves(future, future.getSquare(i,j));
                    for (Square s : attacking){
                        if (s.equals(this.getKing_position())){
                            System.out.println("check");
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public String getType(){
        return type;
    }

}
