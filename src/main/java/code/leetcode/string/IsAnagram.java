package code.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class IsAnagram {
	public static void main(String[] args) {
		isAnagram5("\"\"", "\"\"");
		// isAnagram4("abc", "cba");
		// isAnagram5("rat", "car");
		// isAnagram5("dgqztusjuu", "dqugjzutsu");
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : s.toCharArray())
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		Integer i = null;
		for (char c : t.toCharArray())
			if ((i = map.get(c)) == null)
				return false;
			else if (--i == 0)
				map.remove(c);
			else
				map.put(c, i);
		if (map.size() != 0)
			return false;
		return true;
	}

	public static boolean isAnagram2(String s, String t) {
		if (s.length() != t.length())
			return false;
		char[] sc = s.toCharArray(), tc = t.toCharArray();
		Arrays.sort(sc);
		Arrays.sort(tc);
		for (int i = 0; i < tc.length; i++)
			if (sc[i] != tc[i])
				return false;
		return true;
	}

	public static boolean isAnagram3(String s, String t) {
		if (s.length() != t.length())
			return false;
		char[] sc = s.toCharArray(), tc = t.toCharArray();
		int sums = 0, sumt = 0;
		for (int i = 0; i < tc.length; i++) {
			sums += sc[i];
			sumt += tc[i];
		}
		if (sums != sumt)
			return false;
		Arrays.sort(sc);
		Arrays.sort(tc);
		for (int i = 0; i < tc.length; i++)
			if (sc[i] != tc[i])
				return false;
		return true;
	}

	public static boolean isAnagram4(String s, String t) {
		if (s.length() != t.length())
			return false;
		char[] sc = s.toCharArray(), tc = t.toCharArray();
		int sums = 0, sumt = 0;
		Set<Character> ss = new TreeSet<Character>(), ts = new TreeSet<Character>();
		for (int i = 0; i < tc.length; i++) {
			sums += sc[i];
			sumt += tc[i];
			ss.add(sc[i]);
			ts.add(tc[i]);
		}
		if (sums != sumt || ss.size() != ts.size())
			return false;
		Character[] sc2 = ss.toArray(new Character[0]), tc2 = ts.toArray(new Character[0]);
		for (int i = 0; i < sc2.length; i++) {
			if (sc2[i] != tc2[i])
				return false;
		}
		return true;
	}

	public static boolean isAnagram5(String s, String t) {
		if (s.length() != t.length())
			return false;
		char[] sc2 = new char[26];
		int sums = 0, sumt = 0;
		for (int i = 0; i < s.length(); i++) {
			sums += s.charAt(i);
			sumt += t.charAt(i);
			sc2[s.charAt(i) - 'a']++;
			sc2[t.charAt(i) - 'a']--;
		}
		if (sums != sumt)
			return false;
		for (int i = 0; i < sc2.length; i++)
			if (sc2[i] != 0)
				return false;
		return true;
	}
}
