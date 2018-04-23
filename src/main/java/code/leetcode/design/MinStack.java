package code.leetcode.design;

public class MinStack {
	/** initialize your data structure here. */
	public MinStack() {

	}

	public void push(int x) {
		this.push(new Node(x));
	}

	public int top() {
		return this.pop().val;
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

	private NodeWithMin[] stack = new NodeWithMin[10];
	private int head = -1, tail = 0;

	private Node pop() {
		if (tail > head)
			return null;
		NodeWithMin node = stack[head];
		stack[head--] = null;
		// node.minNode = null;
		return node.node;
	}

	public Node peak() {
		if (tail > head)
			return null;
		return stack[head].node;
	}

	private void push(Node node) {
		if (node == null)
			return;
		Node minNode = this.getMin();
		if (minNode == null)
			minNode = node;
		stack[++head] = new NodeWithMin(node, minNode);
	}

	public Node getMin() {
		if (tail > head)
			return null;
		NodeWithMin node = stack[head];
		if (node == null)
			return null;
		return node.minNode;
	}

}
