import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Viewer extends JFrame implements MouseListener, MouseMotionListener     // # 4: implements required for Listeners
{
    private Game game;

    private int x;
    private int y;
    private Square current;
    private Image background;
    // Constructors
    public Viewer(int fWidth, int fHeight)
    {
        // Create a Ball with the 0 parameter constructor
        // Look at the Ball class to see how this constructor
        // initializes the Ball instance variables
        game = new Game();
        x = 0;
        y = 0;
        current = game.getBoard().getSquare(0,0);
        background = new ImageIcon("Resources/Chessboard_1000.png").getImage();

        setSize(fWidth, fHeight);
        setLocationRelativeTo(null);
        setTitle("Chess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(this);         // # 5: Required for MouseListeners
        addMouseMotionListener(this);   // # 6: Required for MouseMotionListeners

        setVisible(true);
    }

    // Methods
    public static void main(String[] args)
    {
        // Changing DEMO_WIDTH and DEMO_HEIGHT gives you the ability
        // to change the size of the JFrame that hosts the demo
        final int DEMO_WIDTH = 1000;
        final int DEMO_HEIGHT = 800;
        Viewer md = new Viewer(DEMO_WIDTH, DEMO_HEIGHT);
    }

    @Override
    public void paint(Graphics g)
    {

        final int INFO_RECT_TOP_LEFT_X = 0;
        final int INFO_RECT_TOP_LEFT_Y = 0;
        final int INFO_RECT_WIDTH = 800;
        final int INFO_RECT_HEIGHT = 800;

        // Note: The Graphics object g keeps track of the "state" of several attributes
        // In this case, note that it always has a current value for its Color
        // First, set the Color to LIGHT_GRAY to draw the background
        // Next, set the Color to WHITE to draw the information box
        // Finally, set the Color to BLACK to draw the information strings

        // Set the background of the Frame to LIGHT_GRAY
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(getHeight(), getInsets().top, getWidth(), getHeight());
        g.drawImage(background,0,0,getHeight(),getHeight(),this);
        int increment = getHeight()/8;
        for (int x = 0; x < 8; x++){
            for (int y = 0; y < 8; y++){
                if (game.getBoard().getSquare(x,y) != null && game.getBoard().getSquare(x,y).getPiece() != null){
                    g.drawImage(game.getBoard().getSquare(x,y).getPiece().getImage(),
                            (int)((x) * increment),(int)((y) * increment), this);
                }
            }
        }
        if(current != null){
            g.drawImage(current.getPiece().getImage(), x, y, x * increment,y * increment,this);
        }
    }

    /********************************************
     MouseListener event handlers - BEGIN
     ********************************************/

    @Override
    // # 7: Required of a MouseListener
    public void mousePressed(MouseEvent e)
    {
        if (e.getX() < getHeight() && game.getBoard().getSquare((int)(8.0*e.getX()/getHeight()),
                (int)(8.0*e.getY()/getHeight())).hasPiece()){
            if(game.getBoard().getSquare((int)(8.0*e.getX()/getHeight()),
                    (int)(8.0*e.getY()/getHeight())).getPiece().getColor().equals(game.getTurn())){
                current = game.getBoard().getSquare((int)(8.0*e.getX()/getHeight()),
                        (int)(8.0*e.getY()/getHeight()));
            }
        }
        repaint();
    }

    @Override
    // # 8: Required of a MouseListener
    public void mouseReleased(MouseEvent e)
    {
        if(current != null && current.getPiece() != null && current.getPiece().isValidMove(game.getBoard(), current,
                game.getBoard().getSquare((int)(8.0*e.getX()/getHeight()),
                (int)(8.0*e.getY()/getHeight())))){
            int setx = (int)(8.0*e.getX()/getHeight());
            int sety = (int)(8.0*e.getY()/getHeight());
            game.getBoard().getSquare(setx, sety).setPiece(current.getPiece());
            game.getBoard().getSquare(current.getX(), current.getY()).setPiece(null);
            game.switchTurn();
        }
        current = null;
        repaint();
    }

    @Override
    // # 9: Required of a MouseListener
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    // # 10: Required of a MouseListener
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    // # 11: Required of a MouseListener
    public void mouseExited(MouseEvent e)
    {
    }

    /********************************************
     MouseListener event handlers - END
     ********************************************/

    /********************************************
     MouseMotionListener event handlers - BEGIN
     ********************************************/

    @Override
    // # 12: Required of a MouseMotionListener
    public void mouseDragged(MouseEvent e)
    {
        this.x = e.getX();
        this.y = e.getY();

        repaint();
    }

    @Override
    // #13: Required of a MouseMotionListener
    public void mouseMoved(MouseEvent e)
    {
    }

    /********************************************
     MouseMotionListener event handlers - END
     ********************************************/

    public void showValidMoves(ArrayList<Square> arr, Graphics g){
        int increment = getHeight()/8;
        g.setColor(Color.green);
        for (Square s : arr) {
            g.drawOval(increment / 2 + s.getX() * increment,
                    increment / 2 + s.getY() * increment,
                    increment / 2, increment / 2);
        }
    }
}
