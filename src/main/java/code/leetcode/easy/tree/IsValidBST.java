package code.leetcode.easy.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import code.leetcode.TreeNode;

public class IsValidBST {

	public boolean isValidBST2(TreeNode root) {
		if (root == null)
			return true;
		if (root.left != null && root.val <= root.left.val)
			return false;
		if (root.right != null && root.val >= root.right.val)
			return false;
		else
			return isValidBST2(root.left, Long.MIN_VALUE, root.val)
					&& isValidBST2(root.right, root.val, Long.MAX_VALUE);
	}

	private boolean isValidBST2(TreeNode node, long low, long high) {
		if (node == null)
			return true;
		else if (node.left != null && (node.val <= node.left.val || low >= node.left.val))
			return false;
		else if (node.right != null && (node.val >= node.right.val || high <= node.right.val))
			return false;
		else
			return isValidBST(node.left, low, node.val) && isValidBST(node.right, node.val, high);
	}

	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		if (root.left != null && root.val <= root.left.val)
			return false;
		if (root.right != null && root.val >= root.right.val)
			return false;
		else
			return isValidBST(root.left, Long.MIN_VALUE, root.val) && isValidBST(root.right, root.val, Long.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode node, long low, long high) {
		if (node == null)
			return true;
		else if (node.left != null && (node.val <= node.left.val || low >= node.left.val))
			return false;
		else if (node.right != null && (node.val >= node.right.val || high <= node.right.val))
			return false;
		else
			return isValidBST(node.left, low, node.val) && isValidBST(node.right, node.val, high);
	}

	public static TreeNode stringToTreeNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		TreeNode root = new TreeNode(Integer.parseInt(item));
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left = new TreeNode(leftNumber);
				nodeQueue.add(node.left);
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right = new TreeNode(rightNumber);
				nodeQueue.add(node.right);
			}
		}
		return root;
	}

	public static String booleanToString(boolean input) {
		return input ? "True" : "False";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			TreeNode root = stringToTreeNode(line);
			boolean ret = new IsValidBST().isValidBST(root);
			String out = booleanToString(ret);
			System.out.print(out);
		}
	}
}
