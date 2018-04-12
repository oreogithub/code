package code.algorithm.sort;

import java.util.HashSet;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		int a = (1 << 29) - 1;
		System.out.println(a);
		System.out.println(~a == (-1 << 29));
		System.out.println(100 & ~a);
		System.out.println(a & (1 << 29));
		System.out.println(1 | 3);

		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < 10; i++) {
			set.add(i);
		}
		for (Integer i : set.toArray(new Integer[0]))
			System.out.println(i);
	}
}
