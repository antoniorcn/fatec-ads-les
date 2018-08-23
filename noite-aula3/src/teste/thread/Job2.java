package teste.thread;

public class Job2 implements Runnable {
	@Override
	public void run() {
		while (true) {
			System.out.println("Job 2 sendo executado");
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
