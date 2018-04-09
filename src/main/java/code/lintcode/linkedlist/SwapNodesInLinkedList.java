package code.lintcode.linkedlist;

public class SwapNodesInLinkedList {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(10);
		ListNode node2 = new ListNode(8);
		node1.next = node2;
		ListNode node3 = new ListNode(7);
		node2.next = node3;
		ListNode node4 = new ListNode(6);
		node3.next = node4;
		ListNode node5 = new ListNode(4);
		node4.next = node5;
		ListNode node6 = new ListNode(3);
		node5.next = node6;

		swapNodes(node1, 8, 10);
	}

	/**
	 * Definition for ListNode
	 */
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * @param head:
	 *            a ListNode
	 * @param v1:
	 *            An integer
	 * @param v2:
	 *            An integer
	 * @return: a new head of singly-linked list
	 */
	public static ListNode swapNodes(ListNode head, int v1, int v2) {
		// write your code here
		ListNode v1P = null, v2P = null, v1n = null, v2n = null, curr = head;
		while (curr != null) {
			if (v1n != null && v2n != null && (v1P != null || v2P != null))
				break;
			if (curr.val == v1)
				v1n = curr;
			else if (curr.val == v2)
				v2n = curr;
			if (v1n == null)
				v1P = curr;
			if (v2n == null)
				v2P = curr;
			curr = curr.next;
		}
		if (v1n == null || v2n == null)
			return head;
		ListNode node1 = v1n.next, node2 = v2n.next;
		if (node1 == v2n)
			v2n.next = v1n;
		else
			v2n.next = node1;
		if (node2 == v1n)
			v1n.next = v2n;
		else
			v1n.next = node2;
		if (v1P == null)
			head = v2n;
		else if (v1P != v2n)
			v1P.next = v2n;
		if (v2P == null)
			head = v1n;
		else if (v2P != v1n)
			v2P.next = v1n;

		return head;
	}

}
