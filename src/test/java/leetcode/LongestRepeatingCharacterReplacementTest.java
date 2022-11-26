package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestRepeatingCharacterReplacementTest {
    private final LongestRepeatingCharacterReplacement foo = new LongestRepeatingCharacterReplacement();

    @Test
    void test() {
        Assertions.assertEquals(foo.characterReplacement("A", 1), 1);
        Assertions.assertEquals(foo.characterReplacement("ABAB", 2), 4);
        Assertions.assertEquals(foo.characterReplacement("AABABBA", 1), 4);
        Assertions.assertEquals(foo.characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4), 7);
    }
}
