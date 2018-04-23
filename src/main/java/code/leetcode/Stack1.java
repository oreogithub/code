package code.leetcode;

/**
 * ��Ŀ��������ʵ��һ��ջ��ʵ��pop,push,peak,getMin������ȷ��ÿ������ʱ�临�Ӷ�ΪO��1��
 * 
 * @author issuser
 *
 */
public class Stack1 {

	static class Node {
		int val;
	}

	private Node[] stack = new Node[10];
	private Node[] minNodes = new Node[10];
	private int head = 0, tail = 0;

	public Node pop() {
		if (tail > head)
			return null;
		Node node = stack[head];
		stack[head] = null;
		minNodes[head--] = null;
		return node;
	}

	public Node peak() {
		return stack[head];
	}

	public void push(Node node) {
		if (node == null)
			return;
		Node minNode = this.getMin();
		minNodes[head] = minNode.val > node.val ? node : minNode;
		stack[head++] = node;
	}

	public Node getMin() {
		return minNodes[head];
	}

}
