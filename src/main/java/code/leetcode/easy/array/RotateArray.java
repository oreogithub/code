package code.leetcode.easy.array;

public class RotateArray {
	public static void main(String[] args) {
		int[] n = { 1, 2 };
		rotate2(n, 1);
		System.out.println();
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
			n[i] ^= n[t];
			n[t] ^= n[i];
			n[i] ^= n[t];
		}
	}

	public static void rotate2(int[] n, int k) {
		int l = n.length;
		k = k % l;
		int[] temp = new int[l];
		System.arraycopy(n, 0, temp, 0, l);
		for (int i = 0; i < temp.length; i++)
			n[i] = temp[(l - k--) % l];
	}
}
