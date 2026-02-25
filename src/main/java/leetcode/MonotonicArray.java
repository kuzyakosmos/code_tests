package leetcode;

@LeetcodeNumber(number = 896, level = Level.EASY)
public class MonotonicArray {

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1, 2, 3, 4, 5}));
        System.out.println(isMonotonic(new int[]{1, 2, 3, 4, 5, 4}));
        System.out.println(isMonotonic(new int[]{5, 4, 3, 2, 1}));
        System.out.println(isMonotonic(new int[]{1, 2, 3, 2, 1}));
        System.out.println(isMonotonic(new int[]{}));
    }

    public static boolean isMonotonic(int[] nums) {
        boolean increase = true;
        boolean decrease = true;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) increase = false;
            if (nums[i] <= nums[i + 1]) decrease = false;
        }

        return increase || decrease;
    }
}
