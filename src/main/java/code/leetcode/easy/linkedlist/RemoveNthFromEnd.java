package code.leetcode.easy.linkedlist;

import java.util.ArrayList;
import java.util.List;

import code.leetcode.ListNode;

public class RemoveNthFromEnd {

	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		removeNthFromEnd(l, 1);
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode nthNode = null, next = head;
		List<ListNode> list = new ArrayList<ListNode>();
		list.add(next);
		while ((next = next.next) != null) {
			list.add(next);
		}
		ListNode temp = list.get(list.size() - n - 1);
		if (n == 1) {
			temp.next = null;
		} else {
			ListNode nn = temp.next;
			if (nn == null)
				temp.next = nn;
			else {
				ListNode nnn = nn.next;
				temp.next = nnn;
				nn.next = null;
			}
		}
		return head;
	}

}
