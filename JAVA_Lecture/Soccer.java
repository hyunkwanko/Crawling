package exam;

import java.awt.*;
import java.awt.event.*;

import java.io.*;

class MyKeyListener extends KeyAdapter {
	Soccer match;
	int speed = 4;

	MyKeyListener(Soccer m) {
		match = m;
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			match.q.runtoward(5 * speed, 0);
			break;
		case KeyEvent.VK_LEFT:
			match.q.runtoward(-5 * speed, 0);
			break;
		case KeyEvent.VK_UP:
			match.q.runtoward(0, -5 * speed);
			break;
		case KeyEvent.VK_DOWN:
			match.q.runtoward(0, 5 * speed);
			break;
		case KeyEvent.VK_ESCAPE: // ESC ������ ���α׷� ����
			System.exit(0);
			break;
		}
	}
}

public class Soccer {
	CField field;
	Ball ball;
	Player p, q, r;
	int clock;
	int score1 = 0, score2 = 0;
	boolean timeout, goal;

	public static void main(String[] args) {
		new Soccer();
	}

	Soccer() { // �� ��ü�� ����.
		field = new CField(320, 240, this); // �ʵ��� ũ�⸦ �����ڸ� �̿��ؼ� �����.
		Frame f = new Frame("Soccer Graphical");
		f.add(field);
		f.setSize(330, 270);
		f.setVisible(true);
		ball = new Ball(field);
		p = new Player("��", "P", field, -50, 10); // �����ڸ� �̿��ؼ� Player ��ü�� �����.
		q = new Player("��", "Q", field, 50, -10); // �����ڸ� �̿��ؼ� Player ��ü�� �����.
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		start();
	}

	void start() { // ��⸦ �����Ѵ�.
		System.out.println("* START *");
		timeout = false;
		run();
	}

	void stop() {
		timeout = true;
	}

	void run() { // ��Ⱑ ���۵ȴ�.
		clock = 0; // ����� �ð�
		while (!timeout) { // �ð��� true�� �ɶ����� �����Ѵ�.
			clock++; // �ð��� �����Ѵ�.
			System.out.print("[" + clock + "]"); // �ð��� ǥ�����ش�.
			int dist = p.move(ball); // p������ ������ �޷�����. �Ÿ�
			int distq = q.move(ball); // q������ ������ �޷�����. �Ÿ�
			r = p;
			if (distq < dist) { // ���� ������ �Ÿ��� �� // q�� �� ������
				r = q;
				dist = distq; // �� ����� ������ �Ÿ��� ����Ѵ�.
			}
			if (dist < 5) { // 5���� �Ÿ��� ��������� ���� ����.
				r.kick(ball); // ������ ���� ����.
				System.out.print("-> " + r.name + "kicks -> ");
			}
			goal = ball.move(); // ���� ��ġ�� ���� ������ �ƴ��� �����Ѵ�.

			// show(); // ������ ���� ��ġ�� �������� ��ġ�� ǥ���Ѵ�.
			field.repaint();
			try {
				Thread.sleep(30);
			} catch (Exception e) {
			}
			;
			if (clock >= 90)
				stop();

			if (goal) {
				if (ball.x < ball.f.getLeft() + 1) // ���� ������� ���� ���� �⼺���� ������
					score2++;			// �÷��ش�.
		
				if (ball.x > ball.f.getRight() - 1) // ���� �⼺���� ���� ���� ������� ������
					score1++;						// �÷��ش�.
				field.Goal(field.getGraphics());
				field.repaint();
				System.out.println("***GOAL IN***");
				System.out.println("�� : " + score1 + "  :  " + "�� : " + score2); // ������
																					// ������
																					// ��Ÿ����.
				goal = false;
				p.x = -50;
				p.y = 10; // ���� �������� ��ġ�� ���� ��ġ�� ó������ �ʱ�ȭ���ش�.
				q.x = 50;
				q.y = -10;
				ball.x = 0;
				ball.dx = 0;
				ball.y = 0;
				ball.dy = 0;
				// stop();
			}

			try {
				Thread.sleep(400);
			} catch (Exception e) {
			}

			// if (clock > 44){
			// System.out.println("�� : "+score1 + " : " + "�� : " + score2);
			// stop();
			// }
		}
		System.out.println("* TIME OUT *");
	}

	void show() { /* member variables: {field, b, p, q} */
		int dH = 10, dW = 3; /* ��� cell dimension: dHxdW */
		int bx = ball.getX() / dW;
		int by = ball.getY() / dH;
		int px = p.getX() / dW;
		int py = p.getY() / dH;
		int qy = q.getY() / dH;
		int qx = q.getX() / dW;

		hline(field.getRight() / dW - field.getLeft() / dW + 1);
		for (int r = field.getTop() / dH; r <= field.getBottom() / dH; r++) {
			tpr("|");
			for (int i = field.getLeft() / dW; i <= field.getRight() / dW; i++) {
				if (r == by && i == bx) {
					tpr("*");
					if (r == py && i == px) {
						tpr("p");
						i++;
						if (r == qy && i == qx) {
							tpr("q");
							i++;
						}
					} else if (r == qy && i == qx) {
						tpr("q");
						i++;
					}
				} else if (r == py && i == px) {
					tpr("p");
					if (r == qy && i == qx) {
						tpr("q");
						i++;
					}
				} else if (r == qy && i == qx) {
					tpr("q");
				} else { /* if (r == 0 && i == 0) tpr("+"); else */
					tpr(" ");
				}
			}
			tprl("|" + r);
		}
		hline(field.getRight() / dW - field.getLeft() / dW + 1);
	}

	void hline(int n) {
		tpr("+");
		for (int i = 1; i <= n; i++)
			tpr("-");
		tprl("+");
	}

	void tpr(String s) {
		System.out.print(s);
	}

	void tprl(String s) {
		System.out.println(s);
	}
}


class CField extends Canvas{
	int x0, x1, y0, y1, w, h;
	Soccer match;

	CField(int wide, int high, Soccer match) { // ������� ũ�⸦ �����Ѵ�.
		w = wide;
		h = high;
		this.match = match;
		setSize(w, h);
		setBackground(Color.green);
		x1 = w / 2;
		y1 = h / 2;
		x0 = -x1;
		y0 = -y1;
		addKeyListener(new MyKeyListener(match));
		setFocusable(true);
	}

	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.drawRect(0, 0, w, h);
		g.drawLine(getCx(), getCy() + y0, getCx(), getCy() + y1);
		g.drawOval(getCx() - 40, getCy() - 40, 80, 80);

		match.ball.draw(g);
		g.setColor(Color.red);
		match.p.draw(g);
		g.setColor(Color.blue);
		match.q.draw(g);
		drawClock(g);
		drawScoreboard(g);
	}

	void drawScoreboard(Graphics g) {
		g.setColor(Color.red);
		g.drawLine(210, 10, 285, 10);
		g.drawLine(210, 10, 210, 30);
		g.drawLine(210, 30, 285, 30);
		g.drawLine(285, 30, 285, 10);

		g.drawString("-", 244, 25);
		g.drawString(String.valueOf(match.score1), 235, 25);
		g.drawString(String.valueOf(match.score2), 248, 25);
		g.drawString("��", 213, 25);
		g.drawString("��", 270, 25);
	}

	void drawClock(Graphics g) {
		int r = 10, x = w - r - 10, y = r + 10;
		double a = Math.PI / 180 * (-90 + match.clock * (360 / 90));
		g.setColor(Color.DARK_GRAY);
		g.drawOval(x - r, y - r, 2 * r, 2 * r);
		g.drawLine(x, y, (int) (x + r * Math.cos(a)), (int) (y + r * Math.sin(a)));
		
	}
	
	void Goal(Graphics g){
		g.setColor(Color.YELLOW);
		g.drawLine(50, 50, 270, 50);
		g.drawLine(50, 200, 270, 200);
		g.drawLine(50, 50, 50, 200);
		g.drawLine(270, 50, 270, 200);
		g.drawString("G O A L", 140, 125);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
	}

	int getCx() {
		return x1;
	}

	int getCy() {
		return y1;
	}

	int getLeft() {
		return x0;
	}

	int getRight() {
		return x1;
	}

	int getTop() {
		return y0;
	}

	int getBottom() {
		return y1;
	}
}

class Ball { // ���� ���� ��ġ�� �����Ѵ�.
	CField f;
	int x, y;
	double dx, dy;

	Ball(CField f) {
		x = 0;
		dx = 0;
		y = 0;
		dy = 0;
		this.f = f;
	}

	void draw(Graphics g) {
		int radius = 5;
		g.setColor(Color.black);
		g.fillOval(f.getCx() + x - radius, f.getCy() + y - radius, radius * 2, radius * 2);
	}

	boolean move() {
		x = x + (int) dx; // �������� ���� ���ԵǸ� �ӵ��� �ٰԵǰ�, ���� ��ġ�� �̵��ϰ� �ȴ�.
		y = y + (int) dy;
		dx = dx * 0.8; // ���� ��ġ�� ������ �ִ� ���ӵ�.
		dy = dy * 0.8;

		if (y < f.getTop()) // ���� ������� ���� �������
			checkBounds();
		if (y > f.getBottom()) // ���� ������� �Ʒ��� �������
			checkBounds();
		System.out.println("��(" + x + ", " + y + ")."); // ������� ��ġ�� ��Ÿ����.
		return (x > f.getRight() - 1 || x < f.getLeft() + 1); // ���� ���� ������� ��������
																// +1 �� ���, ��������
																// -1 �� ��� true��
																// ��ȯ. ���� �����ȴ�.
	}

	void checkBounds() {
		// if(x<f.getLeft()){
		// dx = -dx;
		// x = 2*f.getLeft()-x;
		// }
		// if(x>f.getRight()){
		// dx = -dx;
		// x = 2*f.getRight()-x;
		// }
		if (y < f.getTop()) { // ���� ������� ���� ���������, ����庸�� �� ���� ��ŭ �ݻ�Ǿ� ������ ���´�.
			dy = -dy;
			y = 2 * f.getTop() - y;
		}
		if (y > f.getBottom()) { // ���� ������� �Ʒ��� ���������, ����庸�� �� ���� ��ŭ �ݻ�Ǿ� ������
									// ���´�.
			dy = -dy;
			y = 2 * f.getBottom() - y;
		}
	}

	void fly(double kx, double ky) { // �������� kick�� ���� ���� ���ư���.
		dx = dx + kx;
		dy = dy + ky;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}
}

class Player {
	CField f;
	int x, y;
	double dx, dy, speed;
	String name, team;

	Player(String name, String tm, CField f, int x0, int y0) { // ������ �̸��� ��ġ�� �����Ѵ�.
		this.name = name;
		x = x0;
		y = y0;
		team = tm;
		this.f = f;
	}

	void draw(Graphics g) {
		g.drawRect(f.getCx() + x - 5, f.getCy() + y - 20, 10, 20);
	}

	int move(Ball b) {
		dash(b);
		x = x + (int) dx;
		y = y + (int) dy;
		int dist = (int) distance(b);
		System.out.print(name + " " + dist + " ");
		return dist;
	}

	double distance(Ball b) { // ���� ������ �Ÿ��� ��ȯ���ش�.
		double x2x = x - b.getX();
		double y2y = y - b.getY();
		return Math.sqrt(x2x * x2x + y2y * y2y); // �������� �����ִ� �Լ�
	}

	void kick(Ball b) { // ������ ���� �Ÿ��� ������� ���� �߷� ����.
		double kx = dx * 2 + randM(10) - 5; // �����Լ��� �̿��ؼ� �ӵ��� ��������.
		double ky = dy * 2 + randM(8) - 5;
		b.fly(kx, ky); // ������ �ӵ��� BallŬ������ ������ ���� ���ư���.
		speed = speed / 2; // ������ �ӵ��� ������ ���δ�.
	}

	double randM(int M) {
		return Math.random() * M;
	}

	void dash(Ball b) { // ������ ���� �����Ѵ�.
		double dist = distance(b) + 1;
		speed = speed * 0.8 + randM(4); // �����Լ��� �̿��ؼ� ���ǵ带 �����Ѵ�.
		dx = (b.getX() - x) / dist * speed; // �������� �̵��ӵ��� ��������.
		dy = (b.getY() - y) / dist * speed;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	void runtoward(int dx, int dy) {
		x += dx;
		y += dy;
	}
}