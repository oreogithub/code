package code.leetcode.easy.other;

public class HammingWeight {
	public int hammingWeight(int n) {
		int weights = 0;
		while (n != 0) {
			weights++;
			n &= n - 1;
		}
		return weights;
	}

}
