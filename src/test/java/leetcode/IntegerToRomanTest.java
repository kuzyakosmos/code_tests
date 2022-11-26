package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerToRomanTest {
    private final IntegerToRoman foo = new IntegerToRoman();

    @Test
    void test() {
        Assertions.assertEquals(foo.intToRoman(3), "III");
        Assertions.assertEquals(foo.intToRoman(58), "LVIII");
        Assertions.assertEquals(foo.intToRoman(1994), "MCMXCIV");
    }
}
