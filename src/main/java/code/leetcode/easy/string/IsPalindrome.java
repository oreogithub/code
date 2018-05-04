package code.leetcode.easy.string;

public class IsPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("aa"));
		// isPalindrome("A man \r\n a plan \r\n a canal: Panama");
		// System.out.println(isPalindrome("Marge, let's \"went.\" I await news
		// telegram."));
	}

	public static boolean isPalindrome(String s) {
		if(s==null||s.length()<2)
			return true;
		s = s.toLowerCase();
		int start = 0, end = s.length() - 1;
		char startchar, endchar;
		while (start < end) {
			startchar = s.charAt(start);
			endchar = s.charAt(end);
			if (!isValid(startchar)) {
				start++;
				continue;
			}
			if (!isValid(endchar)) {
				end--;
				continue;
			}
			if (startchar != endchar)
				return false;
			start++;
			end--;
		}
		return true;
	}

	private static boolean isValid(char c) {
		return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
	}

}
