package code.leetcode.easy.dynamicprogramming;

public class ClimbStairs {
	/**
	 * exceed time limits
	 * 
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		if (n < 3)
			return n;
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

	public int climbStairs2(int n) {
		int step1 = 1, step2 = 1;
		for (int i = 1; i < n; i++) {
			int temp = step2;
			step2 = step1;
			step1 = step1 + temp;
		}
		return step1;
	}
}