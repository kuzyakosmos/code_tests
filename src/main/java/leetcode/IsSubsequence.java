package leetcode;

@LeetcodeNumber(number = 392)
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        //if strings are equals
        if (s.equals(t) || s.equals("")) {
            return true;
        }
        if (t.equals("")) {
            return false;
        }

        int j = 0; int i = 0;
        while (i < s.length()) {
            if (j == t.length()) return false;
            if (s.charAt(i) == t.charAt(j)) {
                if (i == s.length() - 1) {
                    return true;
                }
                j++; i++;
            } else {
                j++;
            }
        }
        return false;
    }
}
