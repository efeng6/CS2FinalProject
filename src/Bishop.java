import javax.swing.*;
import java.util.ArrayList;

public class Bishop extends Piece{
    public Bishop(String color) {
        super(color,"bishop");
        if (super.getColor().equals("white")){
            super.setImage(new ImageIcon("Resources/Chess_blt60.png").getImage());
        }
        else {
            super.setImage(new ImageIcon("Resources/Chess_bdt60.png").getImage());
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
        return arr;
    }

}
