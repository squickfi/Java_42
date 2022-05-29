import java.util.Scanner;

public class Program {

    private static int  mySqrt(int value) {
        double num;
        double half = (double) value / 2;
        do {
        num = half;
        half = (num + (value / num)) / 2;
        } while ((num - half) != 0);
        return (int)half;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean result = true;
        int count = 0;
        System.out.print("-> ");
        int number = sc.nextInt();
        if (number < 2) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        if (number > 2) {
            int numSqrt = mySqrt(number);
            for (int i = 2; i <= numSqrt + 1; ++i) {
                ++count;
                if (number % i == 0) {
                    result = false;
                    break;
                }
            }
        }
        else {
            ++count;
        }
        System.out.print("  ");
        System.out.print(result);
        System.out.print("  ");
        System.out.println(count);
    }
}
