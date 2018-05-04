package code.leetcode.medium.string;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		int max = 0, pre = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>(s.length() / 5);
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			Integer lastIndex = map.put(cs[i], i);
			if (lastIndex == null) {
				pre++;
			} else {
				// when we find the repeat character,
				// we restart form the character next to it
				i = lastIndex;
				map.clear();
				max = max > pre ? max : pre;
				pre = 1;
			}
		}
		return max;
	}
}
