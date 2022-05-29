public class Printer {

	private static final String EGG = "egg";
	// private static final String HEN = "hen";

	private boolean isEgg;

	public Printer() {
		isEgg = true;
	}

	public synchronized void printMassage(String massage) throws InterruptedException {
		if (massage == EGG) {
			while (isEgg == false) {
				wait();
			}
			isEgg = false;
		}
		else {
			while (isEgg == true) {
				wait();
			}
			isEgg = true;
		}
		System.out.println(massage);
		notify();
	}
}