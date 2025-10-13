package leetcode;

@LeetcodeNumber(number = 3, level = Level.MEDIUM)
public class LongestSubstringWithoutRepeatingCharacters {
    //Given a string s, find the length of the longest substring without repeating characters.
    static int lengthOfLongestSubstring(String s) {
        int length = s.length(), longest = 0;
        int[] nextIndex = new int[128];
        System.out.println();
        for (int right = 0, left = 0; right < length; right++) {
            //переставляем l на nextIndex если буква на r уже встречалась
            left = Math.max(nextIndex[s.charAt(right)], left);
            //сравниваем длину текущего отрезка с longest
            longest = Math.max(longest, right - left + 1);
            //где в последний раз встречался символ s.charAt(right)
            nextIndex[s.charAt(right)] = right + 1;
            System.out.println(String.format("r=%s, l=%s, longest=%s, nextIndex for %s=%s", right, left, longest, s.charAt(right),
                    nextIndex[s.charAt(right)]));
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = "";
        for (Character c: s.toCharArray()) {
            System.out.println( (int) c);
        }

//        lengthOfLongestSubstring("abcdef");
    }
}
