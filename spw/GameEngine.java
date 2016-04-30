package spw;

import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameEngine implements KeyListener ,GameReporter {
	GamePanel gp;
	private SpaceShip v;	
	private Timer timer;
	private long score = 0;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
		
	public GameEngine(GamePanel gp, SpaceShip v) {
		this.gp = gp;
		this.v = v;		
		
		gp.sprites.add(v);
		
		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				process();
			}
		});
		timer.setRepeats(true);
		
	}
	
	public void start(){
		timer.start();
	}
	
	private void generateEnemy(){
		Enemy e01 = new Enemy((int)(Math.random()*390), 0);
		gp.sprites.add(e01);
		enemies.add(e01);
	}
	
	private void process(){
		generateEnemy();
		Iterator<Enemy> e_iter01 = enemies.iterator();
		while(e_iter01.hasNext()){
			Enemy e1 = e_iter01.next();
			e1.proceed();
			
			if(!e1.isAlive()){
				e_iter01.remove();
				gp.sprites.remove(e1);
				score += 100;
			}
		}
		gp.updateGameUI(this);
		
		Rectangle2D.Double vr = v.getRectangle();
		Rectangle2D.Double er01;
		for(Enemy e : enemies){
			er01 = e.getRectangle();
			if(er01.intersects(vr)){
				die();
				return;
			}
		}
		gp.updateGameUI(this);
}
	public long getScore(){
 		return score;
 	}
	public void die(){
		timer.stop();
	}

void controlVehicle(KeyEvent e) {
 		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
 			v.move(-1);
 			break;
 		case KeyEvent.VK_RIGHT:
 			v.move(1);
 			break;
 		
 		}
 	}
 	@Override
 	public void keyPressed(KeyEvent e) {
 		controlVehicle(e);
 		
 	}
 
 	@Override
 	public void keyReleased(KeyEvent e) {
 		//do nothing
 	}
 
 	@Override
 	public void keyTyped(KeyEvent e) {
 		//do nothing		
 	}
}
