package code.leetcode.medium.linklist;

import code.leetcode.ListNode;

public class GetIntersectionNode {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		boolean isALonger = true;
		int gap = 0;
		ListNode curA = headA, curB = headB;
		while (curA != null || curB != null) {
			if (curA == null) {
				isALonger = false;
				gap++;
			} else
				curA = curA.next;
			if (curB == null) {
				gap++;
			} else
				curB = curB.next;
		}
		curA = headA;
		curB = headB;
		for (; gap >= 0; gap--) {
			if (isALonger)
				curA = curA.next;
			else
				curB = curB.next;
		}
		for (; curA != null && curB != null; curA = curA.next, curB = curB.next) {
			if (curA == curB)
				return curA;
		}
		return null;
	}
}
