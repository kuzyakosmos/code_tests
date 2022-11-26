package yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CompressArrayTest {
    private final CompressArray foo = new CompressArray();

    @Test
    void test() {
        Assertions.assertEquals("0-5,8-9,11", foo.compress(new int[] {1, 4, 5, 2, 3, 9, 8, 11, 0}));
    }
}
