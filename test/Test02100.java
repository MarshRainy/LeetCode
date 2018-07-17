import pri.MarshR.leetcode.p.ListNode;

/**
 * CreateDate: 2017/01/01
 * Author: MarshR
 */
public class Test02100 {
	public static void main(String[] args) {
		Solution02100 solution = new Solution02100();

		ListNode head = new ListNode(3);
		ListNode node2 = new ListNode(5);
		ListNode node3 = new ListNode(9);
		head.next = node2;
		node2.next = node3;

		ListNode head2 = new ListNode(1);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(11);
		head2.next = node5;
		node5.next = node6;

		ListNode result = solution.mergeTwoLists(head, head2);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}
}
