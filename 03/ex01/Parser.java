public class Parser {

    private static void wrongUsage() {
        System.err.println("Usage: --count=[number_of_threads(int)]");
        System.exit(-1);
    }

    public static int parseCount(String[] args) {

        if (args.length != 1) {
            Parser.wrongUsage();
        }

        char[] str = args[0].toCharArray();
        if (str.length < 9) {
            wrongUsage();
        }

        char[] example = "--count=".toCharArray();
        long count = 0;
        int i = 0;
        for (; i < 8; ++i) {
            if (str[i] != example[i]) {
                wrongUsage();
            }
        }
        for (; i < str.length; ++i) {
            if (str[i] < '0' || str[i] > '9') {
                wrongUsage();
            }
            count *= 10;
            count += str[i] - '0';
            if (count > 2147483647) {
                wrongUsage();
            }
        }
        return (int)count;
    }
}