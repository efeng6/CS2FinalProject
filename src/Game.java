import java.util.ArrayList;

public class Game {
    Board board;
    private String turn;

    public Game(){
        turn = "white";
        board = new Board();
    }

    public Board getBoard() {
        return board;
    }

    public String getTurn() {
        return turn;
    }

    public void switchTurn() {
        if(turn.equals("white")){
            turn = "black";
        }
        else {
            turn = "white";
        }
    }



}
