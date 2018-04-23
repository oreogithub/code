package code.leetcode;

/**
 * 题目：用数组实现一个栈，实现pop,push,peak,getMin方法，确保每个方法时间复杂度为O（1）
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
