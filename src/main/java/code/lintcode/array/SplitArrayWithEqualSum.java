package code.lintcode.array;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SplitArrayWithEqualSum {

	/**
	 * @param nums:
	 *            a list of integer
	 * @return: return a boolean
	 */
	public boolean splitArray(List<Integer> nums) {
		// write your code here
		Integer[] n = (Integer[]) nums.toArray();
		boolean r = false;
		int l = n.length;
		if (l > 6) {
			int[] s = new int[l];
			s[0] = n[0];
			Set<Integer> er = new LinkedHashSet<Integer>();
			for (int i = 1; i < s.length; i++)
				s[i] = n[i] + s[i - 1];
			for (int j = 3; j < l - 3; j++) {
				int s1, s2, s3, s4;
				for (int i = 1; i < j - 1; i++) {
					s1 = s[i - 1];
					s2 = s[j - 1] - s[i];
					if (s1 == s2)
						er.add(s1);
				}
				for (int k = j + 2; k < l - 2; k++) {
					s3 = s[k - 1] - s[j];
					s4 = s[l - 1] - s[k];
					if (s3 == s4 && er.contains(s3))
						return true;
				}
			}
		}
		return r;
	}

	public boolean splitArray2(List<Integer> nums) {
		// write your code here
		Integer[] n = (Integer[]) nums.toArray();
		Integer[] s = new Integer[n.length];
		s[0] = n[0];
		for (int i = 1; i < s.length; i++)
			s[i] = n[i] + s[i - 1];
		int s1, s2, s3, s4;
		for (int i = 1; i < n.length; i++) {
			s1 = s[i];
			for (int j = i + 2; j < n.length; j++) {
				s2 = s[j] - s1;
				if (s1 > s2)
					break;
				else if (s1 < s2)
					continue;
				for (int k = j + 2; k < n.length; k++) {
					s3 = s[k] - s2;
					if (s3 > s2)
						break;
					else if (s3 < s2)
						continue;
					s4 = s[s.length - 1] - s3;
					if (s4 > s3)
						break;
					else if (s4 < s3)
						continue;
					return true;
				}
			}
		}
		return false;
	}

}
