package code.leetcode.string;

public class Atoi {
	public static void main(String[] args) {
		// myAtoi("-2147483649");
		// myAtoi("2147483648");
		// myAtoi("-2147483648");
		// System.out.println(myAtoi(" -11919730356x") == -2147483648);
		System.out.println(myAtoi("    10522545459") == 2147483647);

	}

	public static int myAtoi(String str) {
		if (str == null || str.length() < 1)
			return 0;
		char[] c = str.toCharArray();
		boolean minus = false;
		int firstInd = -1;
		for (int i = 0; i < c.length && c[i] == ' '; i++)
			firstInd = i;
		char sign = c[++firstInd];
		int signNum = 1;
		if (sign == '-') {
			minus = true;
			signNum = -1;
			firstInd++;
		} else if (sign == '+')
			firstInd++;
		else if (sign < '0' || sign > '9')
			return 0;

		StringBuilder sb = new StringBuilder();
		for (int i = firstInd; i < c.length; i++) {
			if (c[i] < '0' || c[i] > '9')
				break;
			sb.append(c[i]);
		}
		if (sb.length() == 0)
			return 0;
		else if (sb.length() > 10)
			return minus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		int result = 0;
		for (char d : sb.toString().toCharArray())
			result = result * 10 + signNum * (d - '0');
		if (minus && result > 0)
			return Integer.MIN_VALUE;
		else if (!minus && result < 0)
			return Integer.MAX_VALUE;
		return result;
	}
}
