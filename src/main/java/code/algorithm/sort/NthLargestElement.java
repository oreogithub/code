package code.algorithm.sort;

public class NthLargestElement {
	public int kthLargestElement(int k, int[] nums) {
		int j;
		for (int i = 1; i < nums.length; i++) {
			int cur = nums[i];
			for (j = i; j > 0 && nums[j - 1] > cur; j--) {
				nums[j] = nums[j - 1];
			}
		}
		return nums[k - 1];
	}
}
