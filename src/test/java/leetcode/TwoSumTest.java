package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoSumTest {
    private final TwoSum twoSum = new TwoSum();

    @Test
    void test() {
        Assertions.assertArrayEquals(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{1, 0});
        Assertions.assertArrayEquals(twoSum.twoSum(new int[]{3, 2, 4}, 6), new int[]{2, 1});
        Assertions.assertArrayEquals(twoSum.twoSum(new int[]{3, 3}, 6), new int[]{1, 0});
    }
}
