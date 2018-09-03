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
		case KeyEvent.VK_ESCAPE: // ESC 누르면 프로그램 종료
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

	Soccer() { // 각 객체를 생성.
		field = new CField(320, 240, this); // 필드의 크기를 생성자를 이용해서 만든다.
		Frame f = new Frame("Soccer Graphical");
		f.add(field);
		f.setSize(330, 270);
		f.setVisible(true);
		ball = new Ball(field);
		p = new Player("손", "P", field, -50, 10); // 생성자를 이용해서 Player 객체를 만든다.
		q = new Player("기", "Q", field, 50, -10); // 생성자를 이용해서 Player 객체를 만든다.
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		start();
	}

	void start() { // 경기를 시작한다.
		System.out.println("* START *");
		timeout = false;
		run();
	}

	void stop() {
		timeout = true;
	}

	void run() { // 경기가 시작된다.
		clock = 0; // 경기의 시간
		while (!timeout) { // 시간이 true가 될때까지 실행한다.
			clock++; // 시간이 증가한다.
			System.out.print("[" + clock + "]"); // 시간을 표시해준다.
			int dist = p.move(ball); // p선수가 공으로 달려간다. 거리
			int distq = q.move(ball); // q선수가 공으로 달려간다. 거리
			r = p;
			if (distq < dist) { // 공과 선수의 거리를 비교 // q가 더 가까우면
				r = q;
				dist = distq; // 더 가까운 선수의 거리를 사용한다.
			}
			if (dist < 5) { // 5보다 거리가 가까워지면 공을 찬다.
				r.kick(ball); // 선수가 공을 찬다.
				System.out.print("-> " + r.name + "kicks -> ");
			}
			goal = ball.move(); // 공의 위치에 따라서 골인지 아닌지 결정한다.

			// show(); // 현재의 공의 위치와 선수들의 위치를 표현한다.
			field.repaint();
			try {
				Thread.sleep(30);
			} catch (Exception e) {
			}
			;
			if (clock >= 90)
				stop();

			if (goal) {
				if (ball.x < ball.f.getLeft() + 1) // 공이 손흥민의 골대로 들어가면 기성용의 점수를
					score2++;			// 올려준다.
		
				if (ball.x > ball.f.getRight() - 1) // 공이 기성용의 골대로 들어가면 손흥민의 점수를
					score1++;						// 올려준다.
				field.Goal(field.getGraphics());
				field.repaint();
				System.out.println("***GOAL IN***");
				System.out.println("손 : " + score1 + "  :  " + "기 : " + score2); // 현재의
																					// 점수를
																					// 나타낸다.
				goal = false;
				p.x = -50;
				p.y = 10; // 현재 선수들의 위치와 공의 위치를 처음으로 초기화해준다.
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
			// System.out.println("손 : "+score1 + " : " + "기 : " + score2);
			// stop();
			// }
		}
		System.out.println("* TIME OUT *");
	}

	void show() { /* member variables: {field, b, p, q} */
		int dH = 10, dW = 3; /* 운동장 cell dimension: dHxdW */
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

	CField(int wide, int high, Soccer match) { // 경기장의 크기를 설정한다.
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
		g.drawString("손", 213, 25);
		g.drawString("기", 270, 25);
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

class Ball { // 현재 공의 위치를 설정한다.
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
		x = x + (int) dx; // 선수들이 공을 차게되면 속도가 붙게되고, 공의 위치가 이동하게 된다.
		y = y + (int) dy;
		dx = dx * 0.8; // 공의 위치에 영향을 주는 가속도.
		dy = dy * 0.8;

		if (y < f.getTop()) // 공이 경기장의 위로 나갈경우
			checkBounds();
		if (y > f.getBottom()) // 공이 경기장의 아래로 나갈경우
			checkBounds();
		System.out.println("공(" + x + ", " + y + ")."); // 현재공의 위치를 나타낸다.
		return (x > f.getRight() - 1 || x < f.getLeft() + 1); // 만약 공이 경기장의 좌측보다
																// +1 일 경우, 우측보다
																// -1 일 경우 true를
																// 반환. 골이 인정된다.
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
		if (y < f.getTop()) { // 공이 경기장의 위로 나갔을경우, 경기장보다 더 나간 만큼 반사되어 안으로 들어온다.
			dy = -dy;
			y = 2 * f.getTop() - y;
		}
		if (y > f.getBottom()) { // 공이 경기장의 아래로 나갔을경우, 경기장보다 더 나간 만큼 반사되어 안으로
									// 들어온다.
			dy = -dy;
			y = 2 * f.getBottom() - y;
		}
	}

	void fly(double kx, double ky) { // 선수들의 kick에 따라 공이 날아간다.
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

	Player(String name, String tm, CField f, int x0, int y0) { // 선수의 이름과 위치를 지정한다.
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

	double distance(Ball b) { // 공과 선수의 거리를 반환해준다.
		double x2x = x - b.getX();
		double y2y = y - b.getY();
		return Math.sqrt(x2x * x2x + y2y * y2y); // 제곱근을 구해주는 함수
	}

	void kick(Ball b) { // 선수가 공과 거리가 가까워져 공을 발로 찬다.
		double kx = dx * 2 + randM(10) - 5; // 랜덤함수를 이용해서 속도가 정해진다.
		double ky = dy * 2 + randM(8) - 5;
		b.fly(kx, ky); // 정해진 속도를 Ball클래스에 전달해 공이 날아간다.
		speed = speed / 2; // 선수의 속도를 반으로 줄인다.
	}

	double randM(int M) {
		return Math.random() * M;
	}

	void dash(Ball b) { // 선수가 공에 접근한다.
		double dist = distance(b) + 1;
		speed = speed * 0.8 + randM(4); // 랜덤함수를 이용해서 스피드를 조절한다.
		dx = (b.getX() - x) / dist * speed; // 선수들의 이동속도가 정해진다.
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