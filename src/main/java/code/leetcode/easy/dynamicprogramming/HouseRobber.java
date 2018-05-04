package code.leetcode.easy.dynamicprogramming;

public class HouseRobber {
	public int rob(int[] nums) {
		if (nums == null)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int last = nums[0], curr = Math.max(last, nums[1]);
		for (int i = 2; i < nums.length; i++) {
			int temp = curr;
			curr = Math.max(last + nums[i], curr);
			last = curr;
		}
		return curr;
	}
}
