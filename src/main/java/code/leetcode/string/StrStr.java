package code.leetcode.string;

public class StrStr {
	public int strStr(String haystack, String needle) {
		if (needle == null || needle.length() == 0)
			return 0;
		if ((haystack == null || haystack.length() == 0))
			return -1;
		char[] hc = haystack.toCharArray(), nc = needle.toCharArray();
		int pos = -1;
		for (int i = 0; i <= hc.length - nc.length; i++) {
			int index = 0;
			for (int j = i; j < hc.length && index < nc.length && hc[j] == nc[index]; j++, index++) {
			}
			if (index == nc.length && hc[i + index - 1] == nc[index - 1]) {
				pos = i;
				break;
			}
		}
		return pos;
	}
}
