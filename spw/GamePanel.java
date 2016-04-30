package spw;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JPanel {
	
	private BufferedImage bi;	
	Graphics2D big;
	ArrayList<Sprite> sprites = new ArrayList<Sprite>();
	private Image img;
	public GamePanel() {
		try{
		bi = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
		img = ImageIO.read(new File("spw\\image\\game31.jpg"));
		big = (Graphics2D) bi.getGraphics();
		//big.setBackground(Color.BLACK);
		} catch (IOException exp) {
            
        }
	}

	public void updateGameUI(GameEngine report_score){
		big.clearRect(0, 0, 400, 600);
		big.drawImage(img, 0, 0, 400, 600, null);
		big.setColor(Color.WHITE);		
		big.drawString(String.format("%08d", report_score.getScore()), 300, 20);
		big.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		for(Sprite s : sprites){
			s.draw(big);
		}
		
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(bi, null, 0, 0);
	}
}
