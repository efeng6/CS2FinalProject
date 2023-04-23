public class Piece {

    private String color;
    private boolean isAlive;
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

    public boolean validMove(Board board, Square loc, Square dest)
    {
        return false;
    }



}
