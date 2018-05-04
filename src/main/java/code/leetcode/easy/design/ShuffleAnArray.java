package code.leetcode.easy.design;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {

	private int[] source;

	public ShuffleAnArray(int[] nums) {
		this.source = nums;
	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return this.source;
	}

	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int[] t = Arrays.copyOf(this.source, source.length);
		Random random = new Random();
		for (int i = t.length - 1; i > 0; i--) {
			int j = random.nextInt(i);
			t[i] ^= t[j];
			t[j] ^= t[i];
			t[i] ^= t[j];
		}
		return t;
	}

	public static void main(String[] args) {
		ShuffleAnArray obj = new ShuffleAnArray(new int[] { 1, 2, 3 });
		int[] param_3 = obj.shuffle();
		int[] param_1 = obj.reset();
		int[] param_2 = obj.shuffle();
	}

}
