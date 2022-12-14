package leetcode;

@LeetcodeNumber(number = 205)
public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) {
            return true;
        }

        return false;
    }
}
