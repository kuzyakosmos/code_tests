package GC;

import java.util.*;

public class GCTest {
    static List<byte[]> leak = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        while (true) {
            for (int i = 0; i < 100; i++) {
                byte[] b = new byte[1024 * 1024]; // 1 MB
                if (Math.random() < 0.1) {
                    leak.add(b); // удерживаем 10%
                }
            }
            Thread.sleep(200);
        }
    }
}
