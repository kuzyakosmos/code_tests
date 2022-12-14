package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {

    public static void main(String[] args) {
        IntersectionOfTwoArraysII intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
        intersectionOfTwoArraysII.intersect(new int[]{1,2}, new int[]{1,2});
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        if (nums1.length > nums2.length) {
            return intersectSorted(nums1, nums2);
        } else {
            return intersectSorted(nums2, nums1);
        }
    }

    private int[] intersectSorted(int[] nums1, int[] nums2) {
        int offset = 0;

        //итерируемся по nums2
        int j = 0;
        for (int i = 0; i < nums2.length; i++) {
            j++;
            if (nums2[i] > nums1[j + offset]) {
                i--;
            } else if (nums2[i] < nums1[j + offset]) {
                offset++;
                nums2[i] = -1;
            }
        }

//        for (int num : nums2) {
//            System.out.print(num + " ");
//        }

        //удаляем -1, пишем в конечный результат
        int[] result = new int[nums2.length - offset];
        j = 0;
        for (int num : nums2) {
            if (num != -1) {
                result[j] = num;
                j++;
            }
        }

        //Для инфо (удалить)
        for (int res : result) {
            System.out.print(res + " ");
        }
        return result;
    }
}
