package code.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthFromEnd {
	
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode nthNode = null, next = head;
		List<ListNode> list = new ArrayList<ListNode>();
		while ((next = next.next) != null) {
			list.add(next);
		}
		deleteNode(list.get(list.size() - n));
		return head;
	}

	public void deleteNode(ListNode node) {
		ListNode next = node.next;
		if (next == null)
			return;
		node.val = next.val;
		node.next = next.next;
		next.next = null;
	}
}
