package yandex;

import java.util.Arrays;
import java.util.Scanner;

//OK
public class E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] a = scanner.nextLine().toCharArray();
        char[] b = scanner.nextLine().toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        if (Arrays.equals(a,b)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
