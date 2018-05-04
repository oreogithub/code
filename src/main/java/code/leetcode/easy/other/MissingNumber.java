package code.leetcode.easy.other;

public class MissingNumber {

	public static void main(String[] args) {
		missingNumber(new int[] { 1, 2 });
	}

	public static int missingNumber(int[] nums) {
		int max = 0, sum = 0;
		for (int i : nums) {
			sum += i;
			max = Math.max(i, max);
		}
		int maxSum = (max + 1) * max / 2;
		if (maxSum == sum)
			if (nums.length == max)
				return 0;
			else
				return max + 1;
		return maxSum - sum;
	}
}
