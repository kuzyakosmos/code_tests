package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindIfPathExistsInGraphTest {
    private final FindIfPathExistsInGraph foo = new FindIfPathExistsInGraph();

    @Test
    void test() {
//        Assertions.assertTrue(foo.validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        Assertions.assertFalse(foo.validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5,4}, {4,3}}, 0, 2));
    }
}
