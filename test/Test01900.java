import pri.MarshR.leetcode.p.ListNode;

public class Test01900 {
	public static void main(String[] args) {
		Solution01900 solution = new Solution01900();

		ListNode node1 = new ListNode(1);

		node1.next = new ListNode(2);
		ListNode node2 = node1.next;

		node2.next = new ListNode(3);
		ListNode node3 = node2.next;

		node3.next = new ListNode(4);
		ListNode node4 = node3.next;

		ListNode result = solution.removeNthFromEnd(node1, 2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}
}
