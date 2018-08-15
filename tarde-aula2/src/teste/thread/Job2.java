package teste.thread;

public class Job2 implements Runnable {
	@Override
	public void run() {
		while(true) { 
			System.out.println("Job - 2");
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
