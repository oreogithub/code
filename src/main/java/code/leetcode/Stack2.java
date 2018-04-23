package code.leetcode;

/**
 * ��Ŀ��������ʵ��һ��ջ��ʵ��pop,push,peak,getMin������ȷ��ÿ������ʱ�临�Ӷ�ΪO��1��
 * 
 * @author issuser
 *
 */
public class Stack2 {

	static class Node {
		int val;
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

	public Node pop() {
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

	public void push(Node node) {
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
