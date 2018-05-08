package code.leetcode.medium.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import code.leetcode.TreeNode;

public class InorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>(20);
		if (root == null)
			return list;
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>(20);
		queue.add(root);
		TreeNode cur = null;
		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (cur.left != null) {
				queue.add(cur.left);
				cur.left = null;
				queue.add(cur);
			} else
				list.add(cur.val);
			if (cur.right != null)
				queue.add(cur.right);
		}
		return null;
	}
}
