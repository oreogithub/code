package code.leetcode.easy.string;

public class ReverseString {
	public String reverseString(String s) {
		if (s == null)
			return s;
		char[] cs = s.toCharArray(), rs = new char[cs.length];
		for (int i = 0, j = cs.length - 1; i < rs.length; i++, j--)
			rs[i] = cs[j];
		return new String(rs);
	}
}
