package code.leetcode.medium.linklist;

import code.leetcode.ListNode;

public class OddEvenList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode odd = head, even = head.next, temp = null, oddTail = odd, evenTail = even;
		head = head.next.next;
		odd.next = null;
		even.next = null;
		boolean isOdd = true;
		while (head != null) {
			if (isOdd) {
				oddTail = oddTail.next = head;
			} else {
				evenTail = evenTail.next = head;
			}
			temp = head;
			head = head.next;
			temp.next = null;
			isOdd = !isOdd;
		}
		oddTail.next = even;
		return odd;
	}
}
