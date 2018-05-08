package code.leetcode.easy.linkedlist;

import code.leetcode.ListNode;

public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode head = null, next = null;
		if (l1.val < l2.val) {
			next = head = l1;
			l1 = l1.next;
		} else {
			next = head = l2;
			l2 = l2.next;
		}
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				next.next = l2;
				break;
			} else if (l2 == null) {
				next.next = l1;
				break;
			} else if (l1.val < l2.val) {
				next.next = l1;
				l1 = l1.next;
			} else {
				next.next = l2;
				l2 = l2.next;
			}
			next = next.next;
		}
		return head;
	}

	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode head = null, next = null;
		return head;
	}
}