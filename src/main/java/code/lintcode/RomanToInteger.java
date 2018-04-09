package code.lintcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public static void main(String[] args) {
		romanToInt("DCXXI");
	}

	private static Map<Character, Integer> map = new HashMap<Character, Integer>() {
		{
			put('I', 1);
			put('V', 5);
			put('X', 10);
			put('L', 50);
			put('C', 100);
			put('D', 500);
			put('M', 1000);
		}
	};

	public static int romanToInt(String s) {
		if (s == null || s.length() < 1)
			return 0;
		int result = 0, preNum = 0;
		for (int index = s.length() - 1; index >= 0; index--) {
			int curNum = map.get(s.charAt(index));
			if (curNum < preNum)
				result -= curNum;
			else
				result += curNum;
			preNum = curNum;
		}
		return result;
	}
}
