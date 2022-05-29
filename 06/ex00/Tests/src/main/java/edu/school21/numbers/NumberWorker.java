package edu.school21.numbers;

public class NumberWorker {

    public boolean isPrime(int number) {
        if (number < 2) {
            throw new IllegalNumberException("Illegal number");
        }
        if (number == 2 || number == 3)
            return true;
        int sqrt = (int)Math.sqrt(number);
        for (int i = 2; i <= sqrt; ++ i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int digitSums(int number) {

        int result = 0;
        int digitsCount = 0;
        for (int num = number; num != 0; num /= 10, ++digitsCount);
        for (; digitsCount >= 0; --digitsCount) {
            result += (number / Math.pow(10, digitsCount) % 10);
        }
        return result;
    }

    public class IllegalNumberException extends RuntimeException {
        IllegalNumberException(String message) {
            super(message);
        }
    }
}
