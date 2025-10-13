package interviews.yandex;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String jewellery = scanner.nextLine();
        String stones = scanner.nextLine();

        byte count = 0;
        for (int i = 0; i < stones.length(); i++) if (jewellery.indexOf(stones.charAt(i)) != -1) count++;
        System.out.println(count);
    }
}
