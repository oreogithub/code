package code.leetcode.easy.math;

public class CountPrimes {

	public static void main(String[] args) {
		countPrimes(10);
	}

	public static int countPrimes(int n) {
		boolean[] prime = new boolean[n];
		for (int i = 2; i < n; i++) {
			if (!prime[i])
				// 将i的2倍、3倍、4倍...都标记为非素数
				for (int j = i * 2; j < n; j = j + i) {
					prime[j] = true;
				}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!prime[i])
				count++;
		}
		return count;
	}

	/*
	 * int count = 0;for( int i = 1;i<n;i++)if(isPrime(i)) count++; return count; }
	 */
	private boolean isPrime(int num) {
		if (num <= 1)
			return false;
		for (int i = 2, mid = num / 2; i <= mid; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
