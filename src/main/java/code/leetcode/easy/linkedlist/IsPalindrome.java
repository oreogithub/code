package code.leetcode.easy.linkedlist;

import code.leetcode.ListNode;

public class IsPalindrome {
	public static void main(String[] args) {
		ListNode head, node;
		// [1,3,0,2]
		head = node = new ListNode(1);// [1,0,1,1]
		node = node.next = new ListNode(3);
		node = node.next = new ListNode(0);
		node = node.next = new ListNode(2);
		isPalindrome(head);
	}

	public static boolean isPalindrome(ListNode head) {
		int lhash = 0, rhash = 0;
		for (int i = 1; head != null; head = head.next, i *= 31) {
			lhash = lhash * 31 + head.val;
			rhash = head.val * i + rhash;
		}
		return lhash == rhash;
	}

	public static boolean isPalindrome1(ListNode head) {
		int lhash = 0, rhash = 0;
		for (int x = 1; head != null; head = head.next, x *= 31) {
			lhash = lhash * 31 + head.val;
			rhash = rhash + head.val * x;
		}
		return lhash == rhash;
		// ListNode mid = head;
		// return false;
	}
}
