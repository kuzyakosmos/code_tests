package interviews.yandex;

import java.util.Scanner;

public class C {
    //timelimit 1.085s > 1s
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            if (n <= 0) return;
            byte temp = scanner.nextByte();
            System.out.println(temp);
            for (int i = 1; i < n; i++) {
                byte next = scanner.nextByte();
                if (temp != next) {
                    temp = next;
                    System.out.println(temp);
                }
            }
        }

/*        int temp = scanner.nextInt();
        System.out.println(temp);
        for (int i = 1; i < n; i++) {
            int next = scanner.nextInt();
            if (temp != next) {
                temp = next;
                System.out.println(temp);
            }
        }*/
    }