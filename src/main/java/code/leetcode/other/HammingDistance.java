package code.leetcode.other;

public class HammingDistance {
	public int hammingDistance(int x, int y) {
		return new HammingWeight().hammingWeight(x ^ y);
	}
}
