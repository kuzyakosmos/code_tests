package interviews.mbition;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Task2 {
    static boolean solution(int[] A, int[] B) {
        int N = A.length;
        Set<Integer> visited = new HashSet<>();
        int curr = A[0];
        while (!visited.contains(curr) && visited.size() <= N) {
            visited.add(curr);
            int finalCurr = curr;
            int index = IntStream.range(0, N).filter(i -> A[i] == finalCurr).findFirst().orElse(-1);
            curr = B[index];
        }
        return visited.size() == N;
    }
}
