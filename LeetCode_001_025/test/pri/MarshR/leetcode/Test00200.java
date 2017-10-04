package pri.MarshR.leetcode;

import pri.MarshR.leetcode.p.ListNode;

public class Test00200 {
	public static void main(String[] args) {
		Solution00200 solution00200 = new Solution00200();

		ListNode l1_1 = new ListNode(2);
		ListNode l1_2 = new ListNode(4);
		ListNode l1_3 = new ListNode(3);
		l1_1.next = l1_2;
		l1_2.next = l1_3;

		ListNode l2_1 = new ListNode(5);
		ListNode l2_2 = new ListNode(6);
		ListNode l2_3 = new ListNode(4);
		l2_1.next = l2_2;
		l2_2.next = l2_3;

		ListNode result = solution00200.addTwoNumbers(l1_1, l2_1);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
