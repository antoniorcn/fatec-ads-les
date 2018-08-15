package teste.thread;

public class Job1 implements Runnable {
	@Override
	public void run() {
		while (true) { 
			System.out.println("Job - 1");
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
