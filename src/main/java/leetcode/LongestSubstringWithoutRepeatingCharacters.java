package leetcode;

@LeetcodeNumber(number = 3, level = Level.MEDIUM)
public class LongestSubstringWithoutRepeatingCharacters {
    //Given a string s, find the length of the longest substring without repeating characters.
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), longest = 0;
        int[] nextIndex = new int[128];
        System.out.println();
        for (int r = 0, l = 0; r < n; r++) {
            //переставляем l на nextIndex если буква на r уже встречалась
            l = Math.max(nextIndex[s.charAt(r)], l);
            //сравниваем длину текущего отрезка с longest
            longest = Math.max(longest, r - l + 1);
            //
            nextIndex[s.charAt(r)] = r + 1;
            System.out.println(String.format("r=%s, l=%s, longest=%s, nextIndex for %s=%s", r, l, longest, s.charAt(r),
                    nextIndex[s.charAt(r)]));
        }

        return longest;
    }
}
