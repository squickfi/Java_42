import java.util.Scanner;

public class Program {

    private static long myPow(long num, int pow) {
        if (pow == 0)
            return 1;
        for (int i = 1; i < pow; ++i)
            num *= num;
        return num;
    }

    private static boolean getWeek(int order) {
        if (order > 17)
            return false;

        Scanner in = new Scanner(System.in);
        System.out.print("-> ");
        String week = in.nextLine();
        if (week.equals("42"))
            return false;

        String w = "Week ";
        if (!week.equals(w + (order + 1))) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        return true;
    }

    private static long findMinGrade() {

        Scanner in = new Scanner(System.in);
        long result = 10;
        System.out.print("-> ");
        for (int i = 0; i < 5; ++i) {
            int num = in.nextInt();
            if (num < result)
                result = num;
        }
        return result;
    }

    private static long addGrade(long results, long num, int order) {
        results += num * myPow(10, order);
        return results;
    }

    public static void printResults(long results) {
        long numToPrint = results % 10;
        for (int order = 0; numToPrint > 0; ++order) {
            numToPrint = (results / myPow(10, order)) % 10;
            if (numToPrint != 0) {
                System.out.print("Week " + (order + 1));
                System.out.print(' ');
                for (int i = 0; i < numToPrint; ++i) {
                    System.out.print('=');
                }
                System.out.println('>');
            }
        }
    }

    public static void main(String[] args) {
        long results = 0;
        boolean isEnd = true;
        for (int order = 0; isEnd; ++order) {
            isEnd = getWeek(order);
            if (isEnd) {
                long num = findMinGrade();
                results = addGrade(results, num, order);
            }
        }
        printResults(results);
    }
}
