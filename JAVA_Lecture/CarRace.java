package exam;

public class CarRace {
	Car one, two, three; // 클래스 Car의 객체를 3개 만든다
	CarRace(){ // 생성자를 통해서 객체를 생산한다.
		one = new Car("프라이드", 1500, 4, 0, 0); // One 이라는 자동차 객체의 이름,cc,문,시작좌표를 지정해준다. 생성자를 이용
		two = new Car("랜드로버", 2000, 2, 0, 10);
		three = new Car("그랜저", 2500, 4, 0, 20);
	}
	
	void rollcall(){ // 각 자동차의 모델명을 출력한다.
		one.info();
		two.info();
		three.info();
	}
	
	void start(){ //ngin이 true, 경주가 시작된다.
		one.start(); // car클래스의 start메소드가 실행 / ngin이 true.
		two.start();
		three.start();
	}
	
	void run(){
		Car winner = null; // 최종 승자.
		int t=0; // 경주가 시작된 시간을 잰다.
		do{
			System.out.println(++t);
			if(one.move()==true) winner = one; // one 객체가 결승선에 도착하면 winner가 된다.
			if(two.move()==true) winner = two; // two 객체가 결승선에 도착하면 winner가 된다.
			if(three.move()==true) winner = three; //three 객체가 결승선에 도착하면 winner가 된다.
			try{Thread.sleep(400);}catch(Exception e){} // 0.4초간 쉰다.
		}while(winner==null); // winner가 나타나면 끝이난다.
		System.out.println("오늘의 승자는");
		winner.info(); // winner의 모델명을 출력한다.
	}
	
	public static void main(String[] args){
		CarRace cr = new CarRace();
		cr.rollcall();
		cr.start();
		cr.run();
	}
}

class Car{
	int nSeats=5, nDoors, cc; // Car 객체의 상세정보.
	double x,y,vx,vy;
	String model;
	boolean ngin=false;
	public Car(String model, int cc, int nDoors, float x, float y){ // 자동차의 생성자.
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
		System.out.println("부릉");
	}
	
	boolean move(){
		vx = spurt(); // spurt로 자동차의 이동거리를 결정한다.
		x = x+vx; // 현재좌표에 vx만큼 더한다.
		display(); // 자동차의 모양을 표시한다.
		System.out.println(model+"at"+(int)x); // 모델명과 현재위치를 나타낸다.
		return ingoal(); // ingoal함수에 따라 리턴한다.
		//y = y+vy;
	}
	
	void display(){ // 자동차의 모양을 나타낸다.
		for(int i=0;i<x;i+=5) System.out.print("-");
		System.out.print(" :=:- ");
	}
	boolean ingoal(){
		return x>200;
	}
	
	double spurt(){
		return (Math.random()-0.3)*30; // 랜덤으로 0~1사이의 난수를 생성
	}
}
