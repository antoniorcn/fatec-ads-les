package teste.thread;

public class TesteJobs {

	public static void main(String[] args) {
		Job1 j1 = new Job1();
		Job2 j2 = new Job2();
		Thread t1 = new Thread( j1 );
		t1.start();
		Thread t2 = new Thread( j2 );
		t2.start();

	}

}
