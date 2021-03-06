package code.leetcode.easy.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar {
	public static void main(String[] args) {
		System.out.println(firstUniqChar2("leetcode"));
	}

	public static int firstUniqChar1(String s) {
		char[] sc = s.toCharArray();
		boolean r = true;
		for (int i = 0; i < sc.length; i++) {
			for (int j = 0; j < sc.length; j++)
				if (sc[i] == sc[j] && i != j)
					r = false;
			if (r)
				return i;
			r = true;
		}
		return -1;
	}

	public static int firstUniqChar2(String s) {
		char[] sc = s.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < sc.length; i++) {
			if (map.get(sc[i]) == null)
				map.put(sc[i], 1);
			else {
				map.put(sc[i], map.get(sc[i]) + 1);
			}
		}
		for (int i = 0; i < sc.length; i++) {
			if (map.get(sc[i]) == 1)
				return i;
		}
		return -1;
	}

	public static int firstUniqChar3(String s) {
		char[] sc = s.toCharArray();
		return -1;
	}
}
