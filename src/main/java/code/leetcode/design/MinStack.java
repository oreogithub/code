package code.leetcode.design;

public class MinStack {
	/** initialize your data structure here. */
	private NodeWithMin[] stack = new NodeWithMin[10];
	private int head = -1, tail = 0;

	public MinStack() {

	}

	public void push(int x) {
		this.push(new Node(x));
	}

	public void pop() {
		if (tail > head)
			return;
		NodeWithMin node = stack[head];
		stack[head--] = null;
		// node.minNode = null;
		// return node.node;
	}

	public int top() {
		if (tail > head)
			return -1;
		NodeWithMin node = stack[head];
		stack[head--] = null;
		// node.minNode = null;
		return node.node.val;
	}

	public int getMin() {
		Node minNode = this.getMinNode();
		if (minNode == null)
			return -1;
		return minNode.val;
	}

	private Node getMinNode() {
		if (tail > head)
			return null;
		NodeWithMin node = stack[head];
		if (node == null)
			return null;
		return node.minNode;
	}

	private void push(Node node) {
		if (node == null)
			return;
		Node minNode = this.getMinNode();
		if (minNode == null)
			minNode = node;
		else
			minNode = minNode.val > node.val ? node : minNode;
		stack[++head] = new NodeWithMin(node, minNode);
	}

	static class Node {
		int val;

		public Node(int val) {
			this.val = val;
		}
	}

	static class NodeWithMin {
		Node node;
		Node minNode;

		public NodeWithMin(Node node, Node minNode) {
			this.node = node;
			this.minNode = minNode;
		}
	}
}
