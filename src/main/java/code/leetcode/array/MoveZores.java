package code.leetcode.array;

public class MoveZores {

	public static void main(String[] args) {
		int[] nums = { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
	}

	public static void moveZeroes(int[] nums) {
		int zi = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				if (zi == -1)
					zi = i;
			} else {
				if (zi != -1) {
					nums[i] = nums[i] ^ nums[zi];
					nums[zi] = nums[i] ^ nums[zi];
					nums[i] = nums[i] ^ nums[zi++];
				}
			}
		}
	}

}
