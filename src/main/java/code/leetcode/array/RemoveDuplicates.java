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
	 * 题目要求：<br>
	 * 给定一个有序数组，你需要原地删除其中的重复内容，使每个元素只出现一次,并返回新的长度。<br>
	 * 不要另外定义一个数组，您必须通过用 O(1) 额外内存原地修改输入的数组来做到这一点。<br>
	 * 示例：<br>
	 * 给定数组: nums = [1,1,2],<br>
	 * 你的函数应该返回新长度 2, 并且原数组nums的前两个元素必须是1和2<br>
	 * 不需要理会新的数组长度后面的元素<br>
	 * <br>
	 * 解题思路：<br>
	 * 双指针指向数组<br>
	 * 
	 * <br>
	 * 难点：[1,1],[1,2]
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
