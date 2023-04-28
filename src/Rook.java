import javax.swing.*;
import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(String color) {
        super(color,"rook");
        if (super.getColor().equals("white")){
            super.setImage(new ImageIcon("Resources/Chess_rlt60.png").getImage());
        }
        else {
            super.setImage(new ImageIcon("Resources/Chess_rdt60.png").getImage());
        }
    }
    public ArrayList<Square> getValidMoves(Board board, Square loc) {
        ArrayList<Square> arr = new ArrayList<Square>();
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
