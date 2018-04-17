package code.leetcode.string;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		// longestCommonPrefix(new String[] { "aa", "a" });
		// System.out.println(longestCommonPrefix(new String[] { "c", "c" }));
		// System.out.println(longestCommonPrefix(new String[] { "", "" }));
		System.out.println(longestCommonPrefix(new String[] { "abab", "aba", "" }));
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		String s = strs[0];
		int index = 0, minLen = s.length();
		for (int i = 1; i < strs.length; i++) {
			minLen = Math.min(minLen, strs[i].length());
		}
		if (minLen == 0)
			return "";
		for (int i = 0; i < minLen; i++) {
			index = i;
			for (int j = 1; j < strs.length; j++) {
				if (s.charAt(i) != strs[j].charAt(i)) {
					index--;
					break;
				}
			}
			if (index != i)
				break;
		}
		if (index == -1)
			return "";
		return s.substring(0, index + 1);
	}
}
