import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Program {

    private static int _arraySize;
    private static int _threadsCount;
    private static int _numberOfElementsToThread;
    private static final int MAX_ARRAY_SIZE = 2000000;
    private static final int MAX_MODULO = 1000;

    private static void wrongUsage() {
        System.err.println("Usage: java Program --arraySize=X --threadsCount=Y");
        System.err.println("0 <= array size(int) <= 2000000");
        System.err.println("0 <= number of threads <= array size");
        System.exit(-1);
    }

    private static void parseArgs(String[] args) {

        if (args.length != 2) {
            wrongUsage();
        }
        
        Scanner scanner = new Scanner(args[0]).useDelimiter("=");
        if (scanner.next().equals("--arraySize") && scanner.hasNextInt()) {
            _arraySize = scanner.nextInt();
            if (_arraySize < 0 || _arraySize > MAX_ARRAY_SIZE) {
                wrongUsage();
            }
        }
        else {
            wrongUsage();
        }
        scanner.close();
        scanner = new Scanner(args[1]).useDelimiter("=");
        if (scanner.next().equals("--threadsCount") && scanner.hasNextInt()) {
            _threadsCount = scanner.nextInt();
            if (_threadsCount < 0 || _threadsCount > _arraySize) {
                wrongUsage();
            }
        }
        else {
            wrongUsage();
        }
        scanner.close();
        _numberOfElementsToThread = _threadsCount != 0 ? _arraySize / _threadsCount : _arraySize;
    }
    public static void main(String[] args) throws InterruptedException {
        
        parseArgs(args);

        ArrayList<Integer> _array = new ArrayList<>(_arraySize);
        Random random = new Random();
        for (int i = 0; i < _arraySize; ++i) {
            _array.add(i, random.nextInt(MAX_MODULO * 2) - MAX_MODULO);
        }

        ArrayList<Integer> threadSums = new ArrayList<>(_threadsCount);

        int sum = 0;
        for (int i = 0; i < _arraySize; ++i) {
            sum += _array.get(i);
        }
        System.out.println("Sum: " + sum);

        Thread[] threads = new Thread[_threadsCount];
        for (int i = 0, j = 0; i < _threadsCount; ++i) {
            if (i != _threadsCount - 1) {
                threads[i] = new Thread(new MyThread(_array, j, j + _numberOfElementsToThread, i, threadSums));
                j += _numberOfElementsToThread;
            }
            else {
                threads[i] = new Thread(new MyThread(_array, j, _array.size(), i, threadSums));
            }
        }

        for (int i = 0; i < _threadsCount; ++i) {
            threads[i].start();
        }

        for (int i = 0; i < _threadsCount; ++i) {
            threads[i].join();
        }

        int sumFromThreads = 0;
        for (int i = 0; i < threadSums.size(); ++i) {
            sumFromThreads += threadSums.get(i);
        }
        System.out.println("Sum by threads: " + sumFromThreads);
    }
}