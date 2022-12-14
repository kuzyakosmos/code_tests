package zalando;

import java.util.ArrayList;
import java.util.Arrays;

class Task22 {
    public static void main(String[] args) {
        int[] uv =  {3,2,1};
        System.out.println(solution(uv));
    }
    public static int solution(int[] A) {
        int[] diffs = new int[A.length - 1];
        for (int i = 0; i < diffs.length; i++) {
            diffs[i] = A[i] - A[i+1];
            System.out.println(diffs[i]);
        }
        return Arrays.stream(diffs).filter(x -> x > 0).sum() + A[A.length-1];
    }
}