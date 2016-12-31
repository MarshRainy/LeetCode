import p.ListNode;
import p019.Solution;

public class Test {
	public static void main(String[] args) {
		Solution solution = new Solution();

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
