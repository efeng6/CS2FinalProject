import javax.swing.*;
import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(String color) {
        super(color,"queen");
        if (super.getColor().equals("white")){
            super.setImage(new ImageIcon("Resources/Chess_qlt60.png").getImage());
        }
        else {
            super.setImage(new ImageIcon("Resources/Chess_qdt60.png").getImage());
        }
    }
    public ArrayList<Square> getValidMoves(Board board, Square loc) {
        ArrayList<Square> arr = new ArrayList<Square>();
        int x = loc.getX();
        int y = loc.getY();
        for (int j = 1; j + x < 8 && j + y < 8; j++) {

            if (board.getSquare(j + x, j + y).hasPiece() &&
                    board.getSquare(j + x, j + y).getPiece().getColor().equals(super.getColor())) {
                break;
            }
            if (board.getSquare(j + x, j + y).hasPiece() &&
                    !board.getSquare(j + x, j + y).getPiece().getColor().equals(super.getColor())) {
                arr.add(board.getSquare(j + x, j + y));
                break;
            }
            arr.add(board.getSquare(j + x, j + y));
        }
        for (int j = 1; j + x < 8 && -j + y >= 0; j++) {
            if (board.getSquare(j + x, -j + y).hasPiece() &&
                    board.getSquare(j + x, -j + y).getPiece().getColor().equals(super.getColor())) {
                break;
            }
            if (board.getSquare(j + x, -j + y).hasPiece() &&
                    !board.getSquare(j + x, -j + y).getPiece().getColor().equals(super.getColor())) {
                arr.add(board.getSquare(j + x, -j + y));
                break;
            }
            arr.add(board.getSquare(j + x, -j + y));
        }

        for (int j = 1; -j + x >= 0 && j + y < 8; j++) {
            if (board.getSquare(-j + x, j + y).hasPiece() &&
                    board.getSquare(-j + x, j + y).getPiece().getColor().equals(super.getColor())) {
                break;
            }
            if (board.getSquare(-j + x, j + y).hasPiece() &&
                    !board.getSquare(-j + x, j + y).getPiece().getColor().equals(super.getColor())) {
                arr.add(board.getSquare(-j + x, j + y));
                break;
            }
            arr.add(board.getSquare(-j + x, j + y));
        }
        for (int j = 1; -j + x >= 0 && -j + y >= 0; j++) {
            if (board.getSquare(-j + x, -j + y).hasPiece() &&
                    board.getSquare(-j + x, -j + y).getPiece().getColor().equals(super.getColor())) {
                break;
            }
            if (board.getSquare(-j + x, -j + y).hasPiece() &&
                    !board.getSquare(-j + x, -j + y).getPiece().getColor().equals(super.getColor())) {
                arr.add(board.getSquare(-j + x, -j + y));
                break;
            }
            arr.add(board.getSquare(-j + x, -j + y));
        }
        for (int i = loc.getX()+1; i < 8; i++){
            if (board.getSquare(i, loc.getY()).hasPiece() &&
                    board.getSquare(i, loc.getY()).getPiece().getColor().equals(super.getColor())){
                break;
            }
            if (board.getSquare(i, loc.getY()).hasPiece() &&
                    !board.getSquare(i, loc.getY()).getPiece().getColor().equals(super.getColor())){
                arr.add(board.getSquare(i, loc.getY()));
                break;
            }
            arr.add(board.getSquare(i, loc.getY()));
        }
        for (int i = loc.getX()-1; i >= 0; i--){
            if (board.getSquare(i, loc.getY()).hasPiece() &&
                    board.getSquare(i, loc.getY()).getPiece().getColor().equals(super.getColor())){
                break;
            }
            if (board.getSquare(i, loc.getY()).hasPiece() &&
                    !board.getSquare(i, loc.getY()).getPiece().getColor().equals(super.getColor())){
                arr.add(board.getSquare(i, loc.getY()));
                break;
            }
            arr.add(board.getSquare(i, loc.getY()));
        }
        for (int i = loc.getY() +1; i < 8; i++){
            if (board.getSquare(loc.getX(),i).hasPiece() &&
                    board.getSquare(loc.getX(),i).getPiece().getColor().equals(super.getColor())){
                break;
            }
            if (board.getSquare(loc.getX(),i).hasPiece() &&
                    !board.getSquare(loc.getX(),i).getPiece().getColor().equals(super.getColor())){
                arr.add(board.getSquare(loc.getX(),i));
                break;
            }
            arr.add(board.getSquare(loc.getX(),i));
        }
        for (int i = loc.getY() -1; i >= 0; i--){
            if (board.getSquare(loc.getX(),i).hasPiece() &&
                    board.getSquare(loc.getX(),i).getPiece().getColor().equals(super.getColor())){
                break;
            }
            if (board.getSquare(loc.getX(),i).hasPiece() &&
                    !board.getSquare(loc.getX(),i).getPiece().getColor().equals(super.getColor())){
                arr.add(board.getSquare(loc.getX(),i));
                break;
            }
            arr.add(board.getSquare(loc.getX(),i));
        }
        return arr;
    }

}
