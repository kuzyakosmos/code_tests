package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestSubstringWithoutRepeatingCharactersTest {
    private final LongestSubstringWithoutRepeatingCharacters foo = new LongestSubstringWithoutRepeatingCharacters();

    @Test
    void test() {
        Assertions.assertEquals(foo.lengthOfLongestSubstring("abcabcbb"), 3);
        Assertions.assertEquals(foo.lengthOfLongestSubstring("bbbbb"), 1);
        Assertions.assertEquals(foo.lengthOfLongestSubstring("pwwkew"), 3);
    }
}
