import pri.MarshR.leetcode.p.ListNode;

import java.util.*;

public class Solution01900 {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		List<ListNode> list = new ArrayList<ListNode>();

		ListNode node = head;
		while (node != null) {
			list.add(node);
			node = node.next;
		}

		if (n == list.size()) {
			return head.next;
		} else {
			ListNode tt = list.get(list.size() - n - 1);
			tt.next = tt.next.next;
			return head;
		}
	}
}
