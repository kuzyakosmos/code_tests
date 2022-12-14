package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        if (nums.length == set.size()) {
            return false;
        }
        return true;
    }
}
