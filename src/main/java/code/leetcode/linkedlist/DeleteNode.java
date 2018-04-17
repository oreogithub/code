package code.leetcode.linkedlist;

public class DeleteNode {
	public void deleteNode(ListNode node) {
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
		next.next = null;
	}
}