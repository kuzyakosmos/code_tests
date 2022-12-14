package leetcode;

import java.util.List;

@LeetcodeNumber(number = 784, level = Level.MEDIUM)
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        byte[] letters = new byte[s.length()];
        char[] dict = s.toLowerCase().toCharArray();
        byte lettersCounter = 0;
        for (byte i = 0; i < dict.length; i++) {
            if (Character.isLetter(dict[i])) {
                letters[lettersCounter] = i;
                lettersCounter++;
            }
        }

        return null;
    }

    public static void main(String[] args) {
//        char c = '0'; //48
        char c = '9'; //57
        int i = c;
        System.out.println(i);
    }
}
