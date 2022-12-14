package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {
    private BinarySearch binarySearch = new BinarySearch();

    @Test
    void test() {
        Assertions.assertEquals(binarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 9), 4);
        Assertions.assertEquals(binarySearch.search(new int[]{-1, 0, 3, 5, 9, 12}, 2), -1);
    }
}
