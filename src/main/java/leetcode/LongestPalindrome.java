package leetcode;

import java.util.Arrays;

@LeetcodeNumber(number = 409)
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(1 % 2);
    }

    public int longestPalindrome(String s) {
        char array[] = s.toCharArray();

        Arrays.sort(array);
        int answer = s.length();
        int counter = 0;
        boolean single = false;
        char prev = '#';

        for (int i = 0; i < array.length; i++) {
            if (array[i] != prev) {
                //записать counter
                answer = answer - counter % 2;
                System.out.println(String.format("Counter: %s, answer: %s", counter, answer));
                if (counter % 2 != 0) single = true;
                //создать новый counter
                counter = 1;
            } else {
                counter++;
            }
            prev = array[i];
        }

        if (single) answer++;
        return answer;
    }
}
