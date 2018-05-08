package code.leetcode.medium.linklist;

import code.leetcode.ListNode;

public class AddTwoNumbers {

	// [2,4,3]
	// [5,6,4]
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode r = null, current = null;
		int sum = 0, carry = 0;
		current = r = new ListNode(0);
		while (l1 != null || l2 != null || carry != 0) {
			sum = carry;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			carry = sum / 10;
			current.val = sum - carry * 10;
			if ((l1 == null || l2 == null) && carry == 0) {
				current.next = l1 == null ? l2 : l1;
				break;
			}
			current = current.next = new ListNode(0);
		}
		return r;
	}

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		ListNode r = null, current = null;
		int sum = 0, carry = 0;
		current = r = new ListNode(0);
		while (l1 != null || l2 != null || carry != 0) {
			sum = carry;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			carry = sum / 10;
			current.val = sum - carry * 10;
			if ((l1 == null || l2 == null) && carry == 0) {
				current.next = l1 == null ? l2 : l1;
				break;
			}
			current = current.next = new ListNode(0);
		}
		return r;
	}
}
