public class Board {
    Square[][] board;
    public Board()
    {
        board = new Square[8][8];
        presetBoard();
    }

    public Board(Square[][] s)
    {
        board = s;
    }

    public void presetBoard(){
        //To finish: manually set the starting positions of all pieces
        //board[0][0] = new Square(0,0, new Rook("black"));

    }

    public Square getSquare(int x, int y){
        return board[x][y];
    }

    public void setSquare(int x, int y, Square s){
        board[x][y] = s;
    }

    public Square[][] getBoard() {
        return board;
    }

}
