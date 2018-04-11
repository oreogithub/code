package code.leetcode.array;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[0] ^= nums[i];
		}
		return nums[0];
	}
}
