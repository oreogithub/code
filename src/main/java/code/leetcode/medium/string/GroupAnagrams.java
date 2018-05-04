package code.leetcode.medium.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import code.leetcode.easy.string.IsAnagram;

public class GroupAnagrams {
	// ["eat","tea","tan","ate","nat","bat"]
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<List<String>>();
		for (int i = 0; i < strs.length; i++) {
			if (strs[i] == null)
				continue;
			List<String> list2 = new ArrayList<String>();
			list2.add(strs[i]);
			list.add(list2);
			for (int j = i + 1; j < strs.length; j++) {
				if (strs[j] == null)
					continue;
				if (IsAnagram.isAnagram5(strs[i], strs[j])) {
					list2.add(strs[j]);
					strs[j] = null;
				}
			}
		}
		return list;
	}

	public List<List<String>> groupAnagrams2(String[] strs) {
		List<List<String>> list = new ArrayList<List<String>>();
		Map<String, Integer> map = new HashMap<String, Integer>(strs.length / 5);
		for (int i = 0; i < strs.length; i++) {
			final String curr = strs[i];
			char[] cs = curr.toCharArray();
			Arrays.sort(cs);
			String key = new String(cs);
			Integer value = map.get(key);
			if (value == null) {
				map.put(key, list.size());
				list.add(new ArrayList<String>(10) {
					{
						this.add(curr);
					}
				});
			} else {
				list.get(value).add(strs[i]);
			}
		}
		return list;
	}
}
