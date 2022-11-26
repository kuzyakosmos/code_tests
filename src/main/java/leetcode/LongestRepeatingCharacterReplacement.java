package leetcode;

import java.util.Arrays;

@LeetcodeNumber(number = 424, level = Level.MEDIUM)
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int longest = 0;
        //largest count of unique characters in the substring
        int largestCount = 0;

        //dict for substring
        int[] dict = new int[26];

        for (int l = 0, r = 0; r < n; r++) {
            dict[s.charAt(r) - 'A']++;
            largestCount = Math.max(largestCount, dict[s.charAt(r) - 'A']);
            if (largestCount >= k) {
                dict[s.charAt(l) - 'A']--;
                l++;
            }

            longest = Math.max(longest, r - l + 1);
        }
        return longest;
    }
}