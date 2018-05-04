package code.leetcode.easy.linkedlist;

public class ReverseList {

	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		reverseList2(l);
	}

	public ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode temp = head;
			head = head.next;
			ListNode t = newHead;
			newHead = temp;
			newHead.next = t;
		}
		return newHead;
	}

	public static ListNode reverseList2(ListNode head) {
		if (head == null)
			return null;
		ListNode newHead = null;
		if (head.next != null) {
			newHead = reverseList2(head.next);
			head.next.next = head;
			head.next = null;
		} else
			newHead = head;
		return newHead;
	}

}
