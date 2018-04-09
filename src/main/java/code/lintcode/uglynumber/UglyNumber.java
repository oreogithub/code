package code.lintcode.uglynumber;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {
	public static void main(String[] args) {

		System.out.println(nthUglyNumber(41) == 150);
		System.out.println(nthUglyNumber(9) == 10);
	}

	public static int nthUglyNumber(int n) {
		int i2 = 0, i3 = 0, i5 = 0;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		for (int i = 1; i < n; i++) {
			int num2 = 2 * list.get(i2), num3 = 3 * list.get(i3), num5 = 5 * list.get(i5);
			int result = Math.min(num2, Math.min(num3, num5));
			if (result == num2) {
				i2++;
			}
			if (result == num3) {
				i3++;
			}
			if (result == num5) {
				i5++;
			}
			list.add(result);
		}
		return list.get(n - 1);
	}

}
