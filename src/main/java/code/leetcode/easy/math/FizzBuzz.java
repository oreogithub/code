package code.leetcode.easy.math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<String>();
		String fizz = "Fizz", buzz = "Buzz", fizzBuzz = "FizzBuzz";
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0)
				list.add(fizzBuzz);
			else if (i % 3 == 0)
				list.add(fizz);
			else if (i % 5 == 0)
				list.add(buzz);
			else
				list.add(Integer.toString(i));
		}
		return list;
	}
}
