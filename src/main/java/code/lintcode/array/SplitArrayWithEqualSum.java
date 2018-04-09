package code.lintcode.array;

import java.util.List;

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
		for (int j = 3; j < nums.size(); j++) {
			int i = j - 2, k = j + 2, sa = 0, sb = 0, sc = 0;
			for (int a = 0; a < i; a++) {
				sa += n[a];
			}
			for (int b = i + 1; b < j; b++) {
				if (sb > sa)
					break;
				sb += n[b];
			}
			for (int c = j + 1; c < k; c++) {
				if (sc > sa)
					break;
				sc += n[c];
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
