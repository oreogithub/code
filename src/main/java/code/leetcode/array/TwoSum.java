package code.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 3, 2, 4 };
		int target = 6;
		twoSum(nums, target);
		System.out.println(-1 << 29);
		System.out.println(0 << 29);
		System.out.println(1 << 29);
		System.out.println(2 << 29);
		System.out.println(3 << 29);

	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> s = new HashMap<Integer, Integer>();
		int[] r = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int t = target - nums[i];
			if (s.containsKey(nums[i])) {
				r[0] = s.get(nums[i]);
				r[1] = i;
				break;
			}
			s.put(t, i);
		}
		return r;
	}
}
