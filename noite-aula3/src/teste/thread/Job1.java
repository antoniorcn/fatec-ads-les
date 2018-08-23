package teste.thread;
public class Job1 implements Runnable {
	public void run() {
		while (true) {
			System.out.println("Job 1 sendo executado");
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Job1 j1 = new Job1();
		Job2 j2 = new Job2();
		Thread t1 = new Thread( j1 );
		t1.start();
		Thread t2 = new Thread( j2 );
		t2.start();
	}
}
