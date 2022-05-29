public class MyThread implements Runnable {

	private static Printer printer = new Printer();
	private String _name;
	private int _timesToPrint;

	public MyThread(String name, int timesToPrint) {
		_name = name;
		_timesToPrint = timesToPrint;
	}

	@Override
	public void run() {
		for (int i = 0; i < _timesToPrint; ++i) {
			try {
				printer.printMassage(_name);
			}
			catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
	}

}