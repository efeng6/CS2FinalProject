import javax.swing.*;
import java.util.ArrayList;

public class Pawn extends Piece{
    public Pawn(String color) {
        super(color,"pawn");
        if (super.getColor().equals("white")){
            super.setImage(new ImageIcon("Resources/Chess_plt60.png").getImage());
        }
        else {
            super.setImage(new ImageIcon("Resources/Chess_pdt60.png").getImage());
        }
    }

    public ArrayList<Square> getValidMoves(Board board, Square loc){
        ArrayList<Square> arr = new ArrayList<Square>();
        if (super.getColor().equals("white")){
            if (loc.getY() == 6 &&
                    board.getSquare(loc.getX(),4).getPiece() == null){
                    arr.add(board.getSquare(loc.getX(),4));
            }
            if(loc.getY() > 0){
                if(board.getSquare(loc.getX(), loc.getY() - 1).getPiece() == null){
                        arr.add(board.getSquare(loc.getX(),loc.getY() - 1));
                }
                if(loc.getX() < 7 &&
                        board.getSquare(loc.getX() + 1, loc.getY() - 1).getPiece() != null &&
                        !board.getSquare(loc.getX() + 1, loc.getY() - 1).getPiece().getColor().equals(super.getColor())){
                        arr.add(board.getSquare(loc.getX() + 1,loc.getY() - 1));
                }
                if(loc.getX() > 0 &&
                        board.getSquare(loc.getX() - 1, loc.getY() - 1).getPiece() != null &&
                        !board.getSquare(loc.getX() - 1, loc.getY() - 1).getPiece().getColor().equals(super.getColor())){
                        arr.add(board.getSquare(loc.getX() - 1,loc.getY() - 1));
                }
            }
        }
        else if (super.getColor().equals("black")){
            if(loc.getY() == 1 && board.getSquare(loc.getX(),3).getPiece() == null) {
                arr.add(board.getSquare(loc.getX(), 3));
            }
            if (loc.getY() < 7){
                if(board.getSquare(loc.getX(), loc.getY() + 1).getPiece() == null) {
                    arr.add(board.getSquare(loc.getX(), loc.getY() + 1));
                }
                if(loc.getX() < 7 &&
                        board.getSquare(loc.getX() + 1, loc.getY() + 1).getPiece() != null &&
                        !board.getSquare(loc.getX() + 1, loc.getY() + 1).getPiece().getColor().equals(super.getColor())){
                    arr.add(board.getSquare(loc.getX() + 1,loc.getY() + 1));
                }
                if(loc.getX() > 0 &&
                        board.getSquare(loc.getX() - 1, loc.getY() + 1).getPiece() != null &&
                        !board.getSquare(loc.getX() - 1, loc.getY() + 1).getPiece().getColor().equals(super.getColor())){
                    arr.add(board.getSquare(loc.getX() - 1,loc.getY() + 1));
                }
            }
        }

        return arr;

    }

}
