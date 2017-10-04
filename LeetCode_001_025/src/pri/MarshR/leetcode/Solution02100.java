package pri.MarshR.leetcode;

import pri.MarshR.leetcode.p.ListNode;

/**
 * CreateDate: 2017/01/01
 * Author: MarshR
 */
public class Solution02100 {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode index = head;
		while (l1 != null || l2 != null) {
			int value = 0;
			if (l1 == null) {
				value = l2.val;
				l2 = l2.next;
			} else if (l2 == null) {
				value = l1.val;
				l1 = l1.next;
			} else {
				if (l1.val > l2.val) {
					value = l2.val;
					l2 = l2.next;
				} else {
					value = l1.val;
					l1 = l1.next;
				}
			}
			ListNode node = new ListNode(value);
			index.next = node;
			index = node;
		}

		return head.next;
	}
}
