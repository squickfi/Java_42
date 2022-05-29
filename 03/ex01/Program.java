public class Program {

	public static void main(String[] args) throws InterruptedException {

		int timesToPrint = Parser.parseCount(args);

		Thread eggThread = new Thread(new MyThread("egg", timesToPrint));
		Thread henThread = new Thread(new MyThread("hen", timesToPrint));

		eggThread.start();
		henThread.start();

		eggThread.join();
		henThread.join();
	}
}