import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class

    private Image Ximage, Oimage;
    private ArrayList<Integer> xCoord, yCoord;
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 500;

    private TicTacToe ttt;

    public TicTacToeViewer(ArrayList<Integer> xCoord, ArrayList<Integer> yCoord, TicTacToe ttt)
    {

        Ximage = new ImageIcon("Resources/X.png").getImage();
        Oimage = new ImageIcon("Resources/O.png").getImage();

        this.ttt = ttt;
        this.setTitle("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    //draws the background and the board
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        g.setFont(new Font("Serif", Font.PLAIN, 30));
        g.setColor(Color.black);


        //draw numbers for board
        // hori.
        for (int i = 0; i < 3; i++)
        {
            g.drawString(String.valueOf(i), (100 * i) + 140, 75);
        }
        //vert.
        for (int i = 0; i < 3; i++)
        {
            g.drawString(String.valueOf(i), 60, (i * 100) + 160);
        }
        //draw the game board
        //draws 4 vertical lines
        for(int i = 100; i <= 400; i+=100){
            g.drawLine(i, 100, i, 400);
        }
        //draw 4 horizonal lines
        for(int i = 100; i <= 400; i+=100) {
            g.drawLine(100, i, 400, i);
        }

        for(int i = 0; i < xCoord.size(); i++) {
            Image pic;
            if(i%2==0) {
                pic = Ximage;
            }
            else {
                pic = Oimage;
            }
            this.draw(pic, xCoord.get(i), yCoord.get(i), g);
        }

        if (ttt.checkTie() == true)
        {
            //Print out tie
            g.drawString("The game is a tie", 125, 450);

        } else if (ttt.getGameOver() == true)
        {
            //Print out the winner
            if (ttt.getWinner() == "O")
            {
                g.drawString("O's win!", 200, 450);
            } else if (ttt.getWinner() == "X") {
                g.drawString("X's win!", 200, 450);
            }
        }
    }

    public void draw(Image pic, int x, int y, Graphics g){
        g.drawImage(pic, x + 5,y + 5, 90, 90, this);
    }
}
