package interviews.ДойчеБанк_задачки_от_Димы_Фарафонова;

import java.util.*;

//todo решить с помощью массива int[128] и HashMap<Character, Integer>

//todo и leetcode заадачу тоже двумя способами решить
class LongestSubstringWithoutRepeatingCharacters {

    static String longestUniqueSubstring(String s) {
        int[] nextIndex = new int[128];
        String result = "";
        for (int left = 0, right = 0; right < s.length(); right++) {
            char chr = s.charAt(right);
            //обновляем если нужно left
            left = Math.max(left, nextIndex[chr]);
            if (right - left + 1 > result.length()) {
                result = s.substring(left, right + 1);
            }
            //записывваем след символ после последнего вхождения right
            nextIndex[chr] = right + 1;
        }
        return result;
    }

    static String longestUniqueSubstringHashMap(String s) {

        Map<Character, Integer> charMap = new HashMap<>();
        String result = "";

        for (int left = 0, right = 0; right < s.length(); right++) {
            char chr = s.charAt(right);

            //update left if needed
            if (charMap.containsKey(chr)) {
                left = Math.max(left, charMap.get(chr) + 1);
            }

            //update result if needed
            if (right - left + 1 > result.length()) {
                result = s.substring(left, right + 1);
            }

            //update charMap
            charMap.put(chr, right);
        }

        return result;
    }

    public static void main(String[] args) {

//        System.out.println("abcdef".substring(0, 0));

        if (true) {
            test("abcabcbb", "abc");
            test("bbbb", "b");
            test("pwwkew", "wke");
            test("abcdeabc", "abcde");
            test("a", "a");
            test("abca", "abc");     // tie -> first one
            test("dvdf", "vdf");     // edge case
            test("tmmzuxt", "mzuxt");   // jump correctness
            test("abcdefghijklmnopqrstuvwxyz", "abcdefghijklmnopqrstuvwxyz"); // max unique

            System.out.printf("%nAll sanity checks completed.%n");
        }
    }

    private static void test(String input, String expected) {
        String got = longestUniqueSubstringHashMap(input);
        if (Objects.equals(got, expected)) {
            System.out.printf("PASS  | input=\"%s\" -> \"%s\"%n", input, got);
        } else {
            System.out.printf("FAIL  | input=\"%s\" -> got \"%s\", expected \"%s\"%n", input, got, expected);
        }
    }
}
