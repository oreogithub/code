package code.leetcode.sortandsearch;

public class FirstBadVersion {

	public static void main(String[] args) {
		System.out.println(firstBadVersion(2126753390));
	}

	/**
	 * nums before start is good. find the first number between good and bad.
	 * 
	 * @return
	 */
	public static int firstBadVersion(int n) {
		int start = 1, end = n;
		int preMid = -1;
		while (start < end) {
			int mid = (end - start) / 2 + start;
			if (isBadVersion(mid)) {
				preMid = mid;
				end = mid - 1;
			} else
				start = mid + 1;
		}
		return isBadVersion(start) ? start : preMid;
	}

	/**
	 * isBadVersion API is defined in the parent class VersionControl.
	 * 
	 * @param version
	 * @return
	 */
	static boolean isBadVersion(long version) {
		return version >= 1702766719;
	}
}
