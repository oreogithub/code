package code.leetcode.linkedlist;

public class HasCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		for (ListNode next = head.next, nn = head.next.next; nn != null
				&& nn.next != null; next = next.next, nn = nn.next.next) {
			if (next == nn)
				return true;
		}
		return false;
	}
}
