package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

@LeetcodeNumber(number = 392)
public class IsSubsequenceTest {
    private static IsSubsequence isSubsequence;

    @BeforeAll
    static void init() {
        isSubsequence = new IsSubsequence();
    }

    @Test
    void isSubsequenceTest() {
//        Assertions.assertFalse(isSubsequence.isSubsequence("acb","ahbgdc"));
//        Assertions.assertFalse(isSubsequence.isSubsequence("axc", "ahbgdc"));
//        Assertions.assertFalse(isSubsequence.isSubsequence("acb", "ahbgdc"));
        Assertions.assertTrue(isSubsequence.isSubsequence("abc","ahbgdc"));
    }
}
