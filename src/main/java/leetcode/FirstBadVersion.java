package leetcode;

@LeetcodeNumber(number = 278, level = Level.EASY)
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        if (n == 1) {
            return n;
        }
        int l = 1;
        int r = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
//            if (isBadVersion(m)) {
//                r = m - 1;
//            } else {
//                l = m + 1;
//            }
        }
        return l;
    }
}
