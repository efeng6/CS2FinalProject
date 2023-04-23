public class King extends Piece{

    public King(int x, int y, String color) {
        super(color);
    }

    public boolean inCheck(Game game){
        if(super.getColor().equals("white")){
            for(Piece p : game.getBlacks()){
            }
        }
        return true;
    }

}
