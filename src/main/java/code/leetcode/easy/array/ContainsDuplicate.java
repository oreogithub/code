package code.leetcode.easy.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> s = new HashSet<Integer>();
		for (int i : nums) {
			if (s.contains(i))
				return true;
			s.add(i);
		}
		return false;
	}

	public boolean containsDuplicate2(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1])
				return true;
		}
		return false;
	}

	public boolean containsDuplicate3(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
		}
		return false;
	}
}
