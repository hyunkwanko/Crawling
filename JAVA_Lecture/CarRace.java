package exam;

public class CarRace {
	Car one, two, three; // Ŭ���� Car�� ��ü�� 3�� �����
	CarRace(){ // �����ڸ� ���ؼ� ��ü�� �����Ѵ�.
		one = new Car("�����̵�", 1500, 4, 0, 0); // One �̶�� �ڵ��� ��ü�� �̸�,cc,��,������ǥ�� �������ش�. �����ڸ� �̿�
		two = new Car("����ι�", 2000, 2, 0, 10);
		three = new Car("�׷���", 2500, 4, 0, 20);
	}
	
	void rollcall(){ // �� �ڵ����� �𵨸��� ����Ѵ�.
		one.info();
		two.info();
		three.info();
	}
	
	void start(){ //ngin�� true, ���ְ� ���۵ȴ�.
		one.start(); // carŬ������ start�޼ҵ尡 ���� / ngin�� true.
		two.start();
		three.start();
	}
	
	void run(){
		Car winner = null; // ���� ����.
		int t=0; // ���ְ� ���۵� �ð��� ���.
		do{
			System.out.println(++t);
			if(one.move()==true) winner = one; // one ��ü�� ��¼��� �����ϸ� winner�� �ȴ�.
			if(two.move()==true) winner = two; // two ��ü�� ��¼��� �����ϸ� winner�� �ȴ�.
			if(three.move()==true) winner = three; //three ��ü�� ��¼��� �����ϸ� winner�� �ȴ�.
			try{Thread.sleep(400);}catch(Exception e){} // 0.4�ʰ� ����.
		}while(winner==null); // winner�� ��Ÿ���� ���̳���.
		System.out.println("������ ���ڴ�");
		winner.info(); // winner�� �𵨸��� ����Ѵ�.
	}
	
	public static void main(String[] args){
		CarRace cr = new CarRace();
		cr.rollcall();
		cr.start();
		cr.run();
	}
}

class Car{
	int nSeats=5, nDoors, cc; // Car ��ü�� ������.
	double x,y,vx,vy;
	String model;
	boolean ngin=false;
	public Car(String model, int cc, int nDoors, float x, float y){ // �ڵ����� ������.
		this.model = model;
		this.cc = cc;
		this.nDoors = nDoors;
		this.x = x;
		this.y = y;
	}
	
	void info(){
		System.out.println(model);
	}
	
	void start(){
		ngin = true;
		System.out.println("�θ�");
	}
	
	boolean move(){
		vx = spurt(); // spurt�� �ڵ����� �̵��Ÿ��� �����Ѵ�.
		x = x+vx; // ������ǥ�� vx��ŭ ���Ѵ�.
		display(); // �ڵ����� ����� ǥ���Ѵ�.
		System.out.println(model+"at"+(int)x); // �𵨸�� ������ġ�� ��Ÿ����.
		return ingoal(); // ingoal�Լ��� ���� �����Ѵ�.
		//y = y+vy;
	}
	
	void display(){ // �ڵ����� ����� ��Ÿ����.
		for(int i=0;i<x;i+=5) System.out.print("-");
		System.out.print(" :=:- ");
	}
	boolean ingoal(){
		return x>200;
	}
	
	double spurt(){
		return (Math.random()-0.3)*30; // �������� 0~1������ ������ ����
	}
}
