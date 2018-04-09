package code.lintcode.digitscount;

public class DigitCounts {

	public static void main(String[] args) {
		System.out.println(digitCounts(1, 12) == 5);
		System.out.println(digitCounts(0, 19) == 2);
		System.out.println(digitCounts(0, 0) == 1);
		System.out.println(digitCounts(0, 109) == 21);
		System.out.println(digitCounts(0, 200) == 32);
		System.out.println(digitCounts(0, 2000) == 493);
	}

	/**
	 * �����ǰλ ���� k������λ+1��* ��ǰλ </br>
	 * �����ǰλ ���� k����λ * ��ǰΪ + ��λ + 1 <br>
	 * �����ǰλ С�� k����λ * ��ǰλ<br>
	 * ���kΪ��Ļ��������������
	 * <ol>
	 * <li>���λ����Ϊ��</li>
	 * <li>ʮλΪ�㣬Ӧ��ȥ10����Ϊ������01��02��������09</li>
	 * </ol>
	 * 
	 */
	public static int digitCounts(int k, int n) {
		int counts = 0;
		int b = 1;

		for (int highDigit = -1, lowDigit = 0; highDigit != 0; b *= 10) {
			int leftN = n / 10;
			int curDigit = n - leftN * 10;
			highDigit = n = leftN;

			if (k > curDigit) {
				counts += highDigit * b;
			} else {
				if (k < curDigit) {
					counts += (highDigit + 1) * b;
				} else {
					counts += highDigit * b + lowDigit + 1;
				}
				if (k == 0 && b > 1)
					counts -= b;
			}
			lowDigit += curDigit * b;
		}

		System.out.print(counts + " ");
		return counts;
	}

	public static int digitCounts2(int k, int n) {
		int counts = 0;
		int b = 1;

		for (int highDigit = -1, lowDigit = 0; highDigit != 0; b *= 10) {
			int leftN = n / 10;
			int curDigit = n - leftN * 10;
			highDigit = n = leftN;

			if (k > curDigit) {
				counts += highDigit * b;
			} else {
				if (k < curDigit) {
					counts += (highDigit + 1) * b;
				} else {
					counts += highDigit * b + lowDigit + 1;
				}
				if (k == 0 && b > 1)
					counts -= b;
			}
			lowDigit += curDigit * b;
		}

		System.out.print(counts + " ");
		return counts;
	}
}
