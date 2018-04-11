package code.leetcode.array;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int l = digits.length;
		for (int i = l - 1; i >= 0; i--) {
			if (digits[i] != 9) {
				digits[i] += 1;
				break;
			}
			digits[i] = 0;
		}
		if (digits[0] == 0) {
			int[] temp = new int[l + 1];
			temp[0] = 1;
			System.arraycopy(digits, 0, temp, 1, l);
			digits = temp;
		}
		return digits;
	}
}
