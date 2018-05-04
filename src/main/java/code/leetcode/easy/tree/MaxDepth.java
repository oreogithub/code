package code.leetcode.easy.tree;

public class MaxDepth {
	public int maxDepth(TreeNode root) {
		int rnum = 1, lnum = 1;
		if (root == null)
			return 0;
		if (root.left != null)
			lnum += maxDepth(root.left);
		if (root.right != null)
			rnum += maxDepth(root.right);
		return Math.max(rnum, lnum);
	}
}
