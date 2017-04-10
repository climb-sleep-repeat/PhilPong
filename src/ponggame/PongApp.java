package ponggame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import ponggame.framework.CollisionManager;

public class PongApp extends Applet implements KeyListener, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Paddle p;
	private Ball b;
	private int bot = 480;
	private int paddleLen = 75;
	private int score = 0;
	private Image image;
	private Graphics second;
	private CollisionManager cm;

	public PongApp() {

		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() {
		setSize(800, 480);
		setBackground(Color.BLACK);
		setFocusable(true);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("PhilPong");
		addKeyListener(this);
		p = new Paddle(bot / 2 - paddleLen / 2, bot, 0, paddleLen);
		b = new Ball(240, 400, 6, 6);
		Random r = new Random();
		b.setSpeedY(r.nextInt(4)+2);
		cm = new CollisionManager();
		cm.AddCollisionObject(p);
		cm.AddCollisionObject(b);
	}

	@Override
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}

		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);
		paint(g);
		// repaint();
	}

	@Override
	public void paint(Graphics g) {
		// g.setColor(Color.BLACK);
		// g.fillRect(0, 0, 800, 480);
		g.setColor(Color.WHITE);
		g.fillRect(0, p.getPosition(), 10, p.getLength());
		g.fillOval(b.getX(), b.getY(), 10, 10);
		g.drawString("Score: "+ score, 400, 10);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			p.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			p.moveDown();
			break;
		case KeyEvent.VK_ENTER:
			restart();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			p.stop();
			break;
		case KeyEvent.VK_DOWN:
			p.stop();
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void restart(){
		cm.DeleteCollisionObject(b);
		cm.DeleteCollisionObject(p);
		b = new Ball(240, 400, 6, 6);
		Random r = new Random();
		b.setSpeedY(r.nextInt(4)*2+2);
		p = new Paddle(bot / 2 - paddleLen / 2, bot, 0, paddleLen);
		cm.AddCollisionObject(p);
		cm.AddCollisionObject(b);
		score = 0;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			p.update();
			b.update();
			if(cm.CheckForCollisions())
				score+=10;
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
