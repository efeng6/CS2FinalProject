import javax.swing.*;
import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(String color) {
        super(color,"knight");
        if (super.getColor().equals("white")){
            super.setImage(new ImageIcon("Resources/Chess_nlt60.png").getImage());
        }
        else {
            super.setImage(new ImageIcon("Resources/Chess_ndt60.png").getImage());
        }
    }
    public ArrayList<Square> getValidMoves(Board board, Square loc) {
        ArrayList<Square> arr = new ArrayList<Square>();
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if (Math.abs((loc.getX()-i) * (loc.getY()-j)) == 2){
                    if(board.getSquare(i,j).hasPiece()) {
                        if (!board.getSquare(i, j).getPiece().getColor().equals(super.getColor())) {
                            arr.add(board.getSquare(i, j));
                        }
                    }
                    else{
                        arr.add(board.getSquare(i,j));
                    }
                }
            }
        }

        return arr;
    }
}
