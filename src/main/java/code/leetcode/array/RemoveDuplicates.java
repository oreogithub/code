package code.leetcode.array;

public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] n = { 1, 2 };
		n = new int[] { 1, 1 };
		System.out.println(removeDuplicates(n));
		for (int i : n) {
			System.out.println(i);
		}

	}

	/**
	 * ��ĿҪ��<br>
	 * ����һ���������飬����Ҫԭ��ɾ�����е��ظ����ݣ�ʹÿ��Ԫ��ֻ����һ��,�������µĳ��ȡ�<br>
	 * ��Ҫ���ⶨ��һ�����飬������ͨ���� O(1) �����ڴ�ԭ���޸������������������һ�㡣<br>
	 * ʾ����<br>
	 * ��������: nums = [1,1,2],<br>
	 * ��ĺ���Ӧ�÷����³��� 2, ����ԭ����nums��ǰ����Ԫ�ر�����1��2<br>
	 * ����Ҫ����µ����鳤�Ⱥ����Ԫ��<br>
	 * <br>
	 * ����˼·��<br>
	 * ˫ָ��ָ������<br>
	 * 
	 * <br>
	 * �ѵ㣺[1,1],[1,2]
	 * 
	 * @param n
	 * @return
	 */
	public static int removeDuplicates(int[] n) {
		if (n.length == 0 || n.length == 1)
			return n.length;
		int cur = 1;
		for (int i = 1; i < n.length; i++) {
			if (n[i] == n[i - 1]) {
				continue;
			}
			n[cur++] = n[i];
		}
		return cur;
	}

}
