public class Program {
    public static void main(String[] args) throws InterruptedException {

        int timesToPrint = Parser.parseCount(args);

        Thread henT = new Thread(new MyThread("Hen", timesToPrint));
        Thread eggT = new Thread(new MyThread("Egg", timesToPrint));

        henT.start();
        eggT.start();

        henT.join();
        eggT.join();

        for (int i = 0; i < timesToPrint; ++i) {
            System.out.println("Human");
        }
    }
}
