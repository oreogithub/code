package code.leetcode.array;

import java.util.Arrays;

public class Intersect {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 2, 1 }, nums2 = { 2 };
		System.out.println(intersect(nums1, nums2));
	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		int l = Math.min(nums1.length, nums2.length);
		int k = 0;
		int[] r = new int[l];
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		for (int i = 0, j = 0; i < nums1.length && k < l && j < nums2.length;)
			if (nums1[i] > nums2[j])
				j++;
			else if (nums1[i] < nums2[j])
				i++;
			else {
				r[k++] = nums1[i++];
				j++;
			}
		return Arrays.copyOf(r, k);
	}

	public static int[] intersect2(int[] nums1, int[] nums2) {
		int l = Math.min(nums1.length, nums2.length);
		int[] r = new int[l];
		int ind = 0;
		for (int i = 0; i < nums1.length; i++)
			for (int j = 0; j < nums2.length && nums1[i] != -1; j++) {
				if (nums2[j] == -1)
					continue;
				if (nums1[i] == nums2[j]) {
					r[ind++] = nums1[i];
					nums1[i] = nums2[j] = -1;
				}
			}
		return Arrays.copyOf(r, ind);
	}
}
