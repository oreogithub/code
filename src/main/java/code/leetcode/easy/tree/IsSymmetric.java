package code.leetcode.easy.tree;

import java.util.ArrayDeque;
import java.util.Queue;

import com.sun.jmx.remote.internal.ArrayQueue;

import code.leetcode.TreeNode;

public class IsSymmetric {
	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		else if (left != null && right != null) {
			if (left.val == right.val)
				return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
			else
				return false;
		} else
			return false;
	}

	public boolean isSymmetric2(TreeNode root) {
		if (root == null)
			return true;
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		if (root.left != null)
			queue.add(root.left);
		if (root.right != null)
			queue.add(root.right);
		TreeNode left = null, right = null;
		while (!queue.isEmpty()) {
			left = queue.poll();
			right = queue.poll();
			if (left != null && right != null) {
				if (left.val != right.val)
					return false;
				if (left.left != null && right.right != null) {
					queue.add(left.left);
					queue.add(right.right);
				} else if ((left.left == null && right.right != null) || (left.left != null && right.right == null))
					return false;
				if (left.right != null && right.left != null) {
					queue.add(left.right);
					queue.add(right.left);
				} else if ((left.right == null && right.left != null) || (left.right != null && right.left == null))
					return false;
				else if ((left == null && right != null) || (left != null && right == null))
					return false;
			} else
				return false;
		}
		return true;
	}
}
