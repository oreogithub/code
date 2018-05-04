package code.leetcode.easy.string;

public class CountAndSay {

	public static void main(String[] args) {
		System.out.println(countAndSay(4));
	}

	public static String countAndSay(int n) {
		StringBuilder sb = new StringBuilder("1");
		for (int i = 1; i < n; i++) {
			char[] c = sb.toString().toCharArray();
			sb.delete(0, c.length);
			char pre = c[0];
			int counts = 1;
			for (int j = 1; j < c.length; j++) {
				if (c[j] == pre)
					counts++;
				else {
					sb.append(counts).append(pre);
					counts = 1;
					pre = c[j];
				}
			}
			sb.append(counts).append(pre);
		}
		return sb.toString();
	}
}
