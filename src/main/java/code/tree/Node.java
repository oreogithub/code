package code.tree;

public class Node implements Comparable<Node> {
	public Node left;
	public Node right;
	public int val;
	public int height;

	public Node(int val) {
		this.val = val;
		this.height = 0;
	}

	public int compareTo(Node o) {
		return 0;
	}

}