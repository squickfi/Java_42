public class MyThread implements Runnable {

    private String _nameToPrint;
    private int _timesToPrint;

    public MyThread(String nameToPrint, int timesToPrint) {
        _nameToPrint = nameToPrint;
        _timesToPrint = timesToPrint;
    }

    @Override
    public void run() {
        for (int i = 0; i < _timesToPrint; ++i) {
            System.out.println(_nameToPrint);
        }
    }
}
