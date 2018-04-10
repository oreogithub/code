package code.lintcode.binary;

public class AddBinary {
	public static void main(String[] args) {
		System.out.println('1' & '1');
		System.out.println('1' & '0');
		System.out.println('0' & '0');
		System.out.println('1' ^ '1');
		System.out.println('1' ^ '0');
		System.out.println('0' ^ '0');
		System.out.println((char) 49);
	}

	public String addBinary(String a, String b) {
		StringBuilder s = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1, c = 0, p = 0;
		while (i >= 0 || j >= 0 || c == 1) {
			c += i >= 0 ? a.charAt(i--) - '0' : 0;
			c += j >= 0 ? b.charAt(j--) - '0' : 0;
			s.append(c % 2);
			c /= 2;
		}
		return s.reverse().toString();
	}
}
