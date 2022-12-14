package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@LeetcodeNumber(number = 724)
public class FindPivotIndexTest {

    private static FindPivotIndex findPivotIndex;

    @BeforeAll
    static void init() {
        findPivotIndex = new FindPivotIndex();
    }


    @Test
    void findPivotIndex() {
//        Assertions.assertEquals(findPivotIndex.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}), 3);
//        Assertions.assertEquals(findPivotIndex.pivotIndex(new int[]{1, 2, 3}), -1);
//        Assertions.assertEquals(findPivotIndex.pivotIndex(new int[]{2, 1, -1}), -1);
//        Assertions.assertEquals(findPivotIndex.pivotIndex(new int[]{1, 1, 1, 3, 4, 6}), 4);
        Assertions.assertEquals(findPivotIndex.pivotIndex(new int[]{-1,-1,-1,-1,-1,0}), 2);
    }
}
