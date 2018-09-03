package exam;


public class Monitor {
	private char buffer[];
	private int n=0;
	private boolean isMt=true, isFul = false;
	
	public Monitor(int N){
		buffer = new char[N];
	}
	
	public synchronized char get(){
		while(isMt==true) try{wait();} catch(Exception e){}
		char x = buffer[n-1]; n--;
		if(n<=0)
			isMt = true;
		else
			isFul = false;
		notify();
		return x;
	}
	
	public synchronized void put(char c){
		while(isFul==true) try{wait();} catch(InterruptedException e){}
		buffer[n++] = c;
		if(n>=buffer.length)
			isFul = true;
		else
			isMt = false;
		notify();
	}
	
	public static void main(String[] args){
		Monitor montor = new Monitor(10);
		Producer p = new Producer(montor, 100);
		Consumer c = new Consumer(montor, 100);
		p.start();
		c.start();
	}
}

class Producer extends Thread{
	private Monitor monitor;
	int N;
	private String key = "abcdefghijklmnopqrstuvwxyz.,?1\n";
	
	public Producer(Monitor m, int n){
		monitor = m;
		N = n;
	}
	
	public void run(){
		for(int i=0;i<N;i++){
			char c = key.charAt((int)(Math.random()*key.length()));
			monitor.put(c);
			try{sleep((int)(Math.random()*100));} catch(Exception e){}
		}
	}
}

class Consumer extends Thread{
	private Monitor monitor;
	int N;
	
	public Consumer(Monitor m, int n){
		monitor = m;
		N=n;
	}
	
	public void run(){
		for(int i=0;i<N;i++){
			char c = monitor.get();
			System.out.print(c);
			try{sleep((int)(Math.random()*100));} catch(Exception e){}
		}
	}
}





