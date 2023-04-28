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
        board[0][0] = new Square(0,0, new Rook("black"));
        board[1][0] = new Square(1,0, new Knight("black"));
        board[2][0] = new Square(2,0, new Bishop("black"));
        board[3][0] = new Square(3,0, new Queen("black"));
        board[4][0] = new Square(4,0, new King("black"));
        board[5][0] = new Square(5,0, new Bishop("black"));
        board[6][0] = new Square(6,0, new Knight("black"));
        board[7][0] = new Square(7,0, new Rook("black"));
        for (int i = 0; i < 8; i++){
            board[i][1] = new Square(i,1, new Pawn("black"));
            for (int j = 2; j < 6; j++){
                board[i][j] = new Square(i,j, null);
            }
            board[i][6] = new Square(i,6, new Pawn("white"));
        }
        board[0][7] = new Square(0,7, new Rook("white"));
        board[1][7] = new Square(1,7, new Knight("white"));
        board[2][7] = new Square(2,7, new Bishop("white"));
        board[3][7] = new Square(3,7, new Queen("white"));
        board[4][7] = new Square(4,7, new King("white"));
        board[5][7] = new Square(5,7, new Bishop("white"));
        board[6][7] = new Square(6,7, new Knight("white"));
        board[7][7] = new Square(7,7, new Rook("white"));

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
