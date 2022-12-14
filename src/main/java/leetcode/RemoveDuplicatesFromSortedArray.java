package leetcode;


public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicatesFromSortedArray.removeDuplicates(nums));
        for (int num: nums) {
            System.out.print(num + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        int x = nums[0];
        int k = 1;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (x != nums[i]) {
                k++;
                j++;
                nums[j] = nums[i];
                x = nums[i];
            }
        }
        return k;
    }
}
