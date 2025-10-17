package test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println(solution(new int[ ] {1, 2, 3}));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        if (A[A.length] < 1) {
            return 1;
        } else {
            return A[A.length] + 1;
        }
    }
}
