public class Solution00200 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null || l2 == null) {
			throw new IllegalArgumentException("参数为空");
		}

		// sum:当前位和; sup:进位; result:生成结果头指针; temp:暂存当前指针
		int sum = l1.val + l2.val;
		int sup = sum / 10;
		ListNode result = new ListNode(sum % 10);
		ListNode temp = result;
		l1 = l1.next;
		l2 = l2.next;

		while (sup != 0 || l1 != null || l2 != null) {
			int s1 = 0;
			int s2 = 0;
			if (l1 != null) {
				s1 = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				s2 = l2.val;
				l2 = l2.next;
			}
			sum = s1 + s2 + sup;
			sup = sum / 10;
			ListNode tempNode = new ListNode(sum % 10);
			temp.next = tempNode;
			temp = tempNode;
		}

		return result;

	}
}
