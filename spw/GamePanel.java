import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;



public class GamePanel extends JPanel
{
	public static void main(String[] args){
	JFrame jframe = new JFrame("SPW_GAMEPANEL");
    jframe.setSize(400,650);
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setLocationRelativeTo(null);
	jframe.getContentPane().setBackground(Color.black);
    //setLayout(new GridLayout(4,6,2,2));
    jframe.setVisible(true);  } 
}