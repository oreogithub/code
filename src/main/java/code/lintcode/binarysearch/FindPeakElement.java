package code.lintcode.binarysearch;

public class FindPeakElement {

	public static void main(String[] args) {
		int[] a = { 1, 2, 1, 3, 4, 5, 7, 6 };
		findPeak(a);
	}

	public static int findPeak(int[] A) {
		// write your code here
		int l = 0, r = A.length - 1;
		while (l < r) {
			int m = (l + r) >>> 1;
			if (A[m] < A[m + 1])
				l = m + 1;
			else
				r = m;
		}
		return l;
	}
}
