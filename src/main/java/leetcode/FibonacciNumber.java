package leetcode;

@LeetcodeNumber(number = 509, level = Level.EASY)
public class FibonacciNumber {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        //0,1,1,2,3,5,8,13,21,34,55
        int prev = 0;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = result + prev;
            prev = result - prev;
        }
        return result;
    }
}
