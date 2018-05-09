package code.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

import code.leetcode.TreeNode;

public class ZigzagLevelOrder {

	// 3
	// / \
	// 9 20
	// **/ \
	// *15 7
	// [
	// [3],
	// [20,9],
	// [15,7]
	// ]
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>(30);
		Stack<TreeNode> right = new Stack<TreeNode>(), left = new Stack<TreeNode>();
		addFirst(left, root);

		boolean rightToLeft = true;
		TreeNode cur = null;
		int numsOnCurrLevel = left.size();
		List<Integer> list2 = new ArrayList<Integer>(20);
		Stack<TreeNode> curS = left;
		while (!curS.isEmpty() && (cur = curS.pop()) != null) {
			list2.add(cur.val);
			if (rightToLeft) {
				addFirst(right, cur.left);
				addFirst(right, cur.right);
			} else {
				addFirst(left, cur.right);
				addFirst(left, cur.left);
			}
			if (--numsOnCurrLevel == 0) {
				list.add(list2);
				list2 = new ArrayList<Integer>(20);
				rightToLeft = !rightToLeft;
				curS = rightToLeft ? left : right;
				numsOnCurrLevel = curS.size();
			}
		}
		return list;
	}

	private void addFirst(Stack<TreeNode> queue, TreeNode node) {
		if (node == null)
			return;
		queue.push(node);
	}
}
