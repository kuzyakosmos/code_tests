package leetcode;

import org.junit.jupiter.api.Test;

public class FindAllAnagramsInAStringTest {
    private final FindAllAnagramsInAString findAllAnagramsInAString = new FindAllAnagramsInAString();

    @Test
    void test() {
//        System.out.println(findAllAnagramsInAString.findAnagrams("abab", "ab"));
        System.out.println(findAllAnagramsInAString.findAnagrams("cbaebabacd", "abc"));
    }
}
