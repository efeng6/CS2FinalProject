import javax.swing.*;
import java.awt.*;

public class King extends Piece{

    public King(String color) {
        super(color, "king");
        if (super.getColor().equals("white")){
            super.setImage(new ImageIcon("Resources/Chess_klt60.png").getImage());
        }
        else{
            super.setImage(new ImageIcon("Resources/Chess_kdt60.png").getImage());
        }
    }

//    public boolean inCheck(Game game){
//        if(super.getColor().equals("white")){
//            for(Piece p : game.getBlacks()){
//            }
//        }
//        return true;
//    }

}
