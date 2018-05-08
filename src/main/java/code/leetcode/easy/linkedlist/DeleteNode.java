package code.leetcode.easy.linkedlist;

import code.leetcode.ListNode;

public class DeleteNode {
	public void deleteNode(ListNode node) {
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
		next.next = null;
	}
}