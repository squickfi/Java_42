import java.util.ArrayList;

public class MyThread implements Runnable {

    private static ArrayList<Integer> _threadSums;

    private ArrayList<Integer> _array;
    private int _sum;
    private int _threadNumber;
    private int _from;
    private int _to;

    public MyThread(ArrayList<Integer> array, int from, int to, int threadNumber, ArrayList<Integer> threadSums) {

        _array = new ArrayList<>(to - from);
        for (int i = from; i < to; ++i) {
            _array.add(array.get(i));
        }
        _sum = 0;
        _threadNumber = threadNumber;
        _from = from;
        _to = to;
        _threadSums = threadSums;
    }

    private void addSum(int threadNumber, int sum) {
        synchronized(_threadSums) {
            _threadSums.add(sum);
        }
    }

    @Override
    public void run() {

        for (int i = 0; i < _array.size(); ++i) {
            _sum += _array.get(i);
        }

        addSum(_threadNumber, _sum);
        System.out.println("Thread " + _threadNumber + ": from " + _from + " to " + (_to - 1) + " sum is " + _sum);
    }
}