package code.tree.avl;

import code.tree.Node;
import code.tree.TreeUtil;

public class AVL {

	public static void main(String[] args) {
		int[] inputs = { 3, 2, 1, 4, 5, 6, 7 };
		for (int i : inputs) {
			insert(i);
		}
		printTree(root);
		int[] inputs2 = { 16, 15, 14, 13, 12, 11, 10, 9, 8 };
		for (int i : inputs2) {
			insert(i);
		}
		printTree(root);
	}

	static Node root;

	public static void insert(int val) {
		root = insert(val, root);
	}

	public static Node insert(int val, Node node) {
		if (node == null)
			return new Node(val);
		if (val > node.val) {
			node.right = insert(val, node.right);
			if (isBalance(node.right, node.left))
				if (val < node.right.val)
					node = doubleRotateRightChild(node);
				else
					node = rotateRightChild(node);
		} else if (val < node.val) {
			node.left = insert(val, node.left);
			if (isBalance(node.left, node.right))
				if (val > node.left.val)
					node = doubleRotateLeftChild(node);
				else
					node = rotateLeftChild(node);
		}
		node.height = getMaxHeight(node) + 1;
		return node;
	}

	public static Node rotateRightChild(Node node) {
		Node right = node.right;
		node.right = right.left;
		right.left = node;
		node.height = getMaxHeight(node) + 1;
		right.height = getMaxHeight(right) + 1;
		return right;
	}

	public static Node rotateLeftChild(Node node) {
		Node left = node.left;
		node.left = left.right;
		left.right = node;
		node.height = getMaxHeight(node) + 1;
		left.height = getMaxHeight(left) + 1;
		return left;
	}

	public static Node doubleRotateLeftChild(Node k3) {
		k3.left = rotateRightChild(k3.left);
		return rotateLeftChild(k3);
	}

	public static Node doubleRotateRightChild(Node k1) {
		k1.right = rotateLeftChild(k1.right);
		return rotateRightChild(k1);
	}

	private static boolean isBalance(Node node1, Node node2) {
		return (height(node1) - height(node2)) == 2;
	}

	private static int getMaxHeight(Node node) {
		return node == null ? -1 : Math.max(height(node.left), height(node.right));
	}

	private static int height(Node node) {
		return node == null ? -1 : node.height;
	}

	private static void printTree(Node node) {
		if (node == null)
			return;
		TreeUtil.levelTraversal(node);

	}
}
