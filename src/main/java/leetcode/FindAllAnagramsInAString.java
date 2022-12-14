package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@LeetcodeNumber(number = 438, level = Level.MEDIUM)
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        Map<Character, Integer> dict = setupDict(p, p.length());
        Map<Character, Integer> substring = setupDict(s, p.length());

        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (dict.equals(substring)) result.add(i);
            if (i < s.length() - p.length()) {
                removeFromDict(substring, s.charAt(i));
                addToDict(substring, s.charAt(i + p.length()));
            }
        }
        return result;
    }

    Map<Character, Integer> setupDict(String s, int length) {
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            addToDict(dict, c);
        }
        return dict;
    }

    void addToDict(Map<Character, Integer> dict, char c) {
        if (dict.containsKey(c)) {
            int amount = dict.get(c);
            dict.put(c, ++amount);
        } else {
            dict.put(c, 1);
        }
    }

    void removeFromDict(Map<Character, Integer> dict, char c) {
        if (dict.containsKey(c) && dict.get(c) > 1) {
            int amount = dict.get(c);
            dict.put(c, --amount);
        } else {
            dict.remove(c);
        }
    }
}
