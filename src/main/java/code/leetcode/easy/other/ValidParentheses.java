package code.leetcode.easy.other;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {
	public static void main(String[] args) {
		isValid("]");
	}

	public static boolean isValid(String s) {
		char[] cs = s.toCharArray();
		List<Character> list = new ArrayList<Character>();
		for (char c : cs) {
			if (c == '(' || c == '{' || c == '[')
				list.add(c);
			else {
				if (list.size() == 0)
					return false;
				Character lc = list.remove(list.size() - 1);
				if ((lc == '(' && c == ')') || (lc == '{' && c == '}') || (lc == '[' && c == ']'))
					continue;
				else
					return false;
			}
		}
		return list.isEmpty();
	}
}
