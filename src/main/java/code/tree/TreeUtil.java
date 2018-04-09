package code.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class TreeUtil {

	/**
	 * 先序遍历
	 * 
	 * @param root
	 */
	public static void preOrderTraversal(Node root) {
		if (root == null)
			return;
		System.out.println(root.val);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}

	/**
	 * 中序遍历
	 * 
	 * @param root
	 */
	public static void inOrderTraversal(Node root) {
		if (root == null)
			return;
		inOrderTraversal(root.left);
		System.out.println(root.val);
		inOrderTraversal(root.right);
	}

	/**
	 * 后序遍历
	 * 
	 * @param root
	 */
	public static void postOrderTraversal(Node root) {
		if (root == null)
			return;
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.println(root.val);
	}

	/**
	 * 层序遍历
	 * 
	 * @param root
	 */
	public static void levelTraversal(Node root) {
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.offer(root);
		Node current = null;
		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.println(current.val);
			if (current.left != null)
				queue.offer(current.left);
			if (current.right != null)
				queue.offer(current.right);
		}
	}

}
