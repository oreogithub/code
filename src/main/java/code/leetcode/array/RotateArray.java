package code.leetcode.array;

public class RotateArray {
	public static void main(String[] args) {
		int[] n = { 1, 2 };
		rotate(n, 1);
	}

	public static void rotate(int[] n, int k) {
		int l = n.length;
		k = k % l;
		if (k == 0 || l < 2 || l == k)
			return;
		reverse(n, l - k, l - 1);
		reverse(n, 0, l - k - 1);
		reverse(n, 0, l - 1);
	}

	public static void reverse(int[] n, int s, int e) {
		for (int i = s, t = e; i < t; i++, t--) {
			int temp = n[i];
			n[i] = n[t];
			n[t] = temp;
		}
	}
}
