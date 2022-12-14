package leetcode;

@LeetcodeNumber(number = 70, level = Level.EASY)
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int a = 2, b = 1;

        for (int i = 3; i < n; i++) {
            a = a + b;
            b = a - b;
            System.out.println(String.format("n = %s, a = %s, b = %s", i, a, b));
        }
        return a;
    }
}
