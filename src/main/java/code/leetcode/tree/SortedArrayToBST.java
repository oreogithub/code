package code.leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SortedArrayToBST {

	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public static String treeNodeToString(TreeNode root) {
		if (root == null) {
			return "[]";
		}

		String output = "";
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.add(root);
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (node == null) {
				output += "null, ";
				continue;
			}

			output += String.valueOf(node.val) + ", ";
			nodeQueue.add(node.left);
			nodeQueue.add(node.right);
		}
		return "[" + output.substring(0, output.length() - 2) + "]";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			int[] nums = stringToIntegerArray(line);

			TreeNode ret = new SortedArrayToBST().sortedArrayToBST(nums);

			String out = treeNodeToString(ret);

			System.out.print(out);
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0)
			return null;
		TreeNode root = push(nums, 0, nums.length - 1);
		return root;
	}

	private TreeNode push(int[] nums, int start, int end) {
		int mid = (end + start) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		if (start != end)
			if (mid == start) {
				node.right = new TreeNode(nums[end]);
			} else {
				node.left = push(nums, start, mid - 1);
				node.right = push(nums, mid + 1, end);
			}
		return node;
	}

}
