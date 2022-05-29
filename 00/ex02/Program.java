import java.util.Scanner;

public class Program {

    private static int checkSum(int number) {
        int result = 0;
        result += number % 10;
        result += (number / 10) % 10;
        result += (number / 100) % 10;
        result += (number / 1000) % 10;
        result += (number / 10000) % 10;
        result += (number / 100000) % 10;
        return result;
    }

    private static int  mySqrt(int value) {
        double num;
        double half = (double) value / 2;
        do {
        num = half;
        half = (num + (value / num)) / 2;
        } while ((num - half) != 0);
        return (int)half;
    }

    private static boolean isPrime(int number) {
        if (number > 2) {
            int numSqrt = mySqrt(number);
            for (int i = 2; i <= numSqrt + 1; ++i) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0, number = 0;
        while (number != 42) {
            System.out.print("-> ");
            number = in.nextInt();
            if (number < 2) {
                System.err.println("IllegalArgument");
            }
            else {
                if (isPrime(checkSum(number))) {
                    ++count;
                }
            }
        }
        System.out.print("   Count of coffee - request - ");
        System.out.println(count);
    }

}
