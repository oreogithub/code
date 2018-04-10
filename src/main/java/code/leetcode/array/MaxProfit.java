package code.leetcode.array;

public class MaxProfit {
	public static void main(String[] args) {
		// int[] p = { 1, 2 };
		// int[] p = { 2, 1 };
		int[] p = { 1, 2, 4 };
		System.out.println(maxProfit(p));
	}

	public static int maxProfit(int[] p) {
		int m = 0, b = -1;
		for (int i = 0; i < p.length - 1; i++) {
			if (p[i] > p[i + 1]) {
				if (b != -1) {
					m += p[i] - p[b];
					b = -1;
				}
			} else {
				if (b == -1)
					b = i;
			}
		}
		if (b != -1)
			m += p[p.length - 1] - p[b];
		return m;
	}
}
