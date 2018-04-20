package code.leetcode.sortandsearch;

public class Merge {

	public static void main(String[] args) {
		merge(new int[] { 1, 2, 3, 0, 0, 0 }, 3, new int[] { 2, 5, 6 }, 3);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int last = m + n - 1, l1 = m - 1, l2 = n - 1; last >= 0; last--) {
			int max;
			if (l1 < 0) {
				max = nums2[l2--];
			} else if (l2 < 0) {
				max = nums1[l1--];
			} else
				max = nums1[l1] > nums2[l2] ? nums1[l1--] : nums2[l2--];
			nums1[last] = max;
		}
	}
}
