package interviews.yandex;

import java.util.Scanner;

//wrong answer 11 testcase
public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        short n = scanner.nextShort();
        int counter = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int next = scanner.nextByte();
            if (next == 1) {
                counter++;
            } else {
                counter = 0;
            }
            answer = Math.max(answer, counter);
        }
        System.out.println(counter);
    }
}
