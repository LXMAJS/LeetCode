package medium;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_19 {

	/**
	 * 链表的定义
	 */
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p = head;
		ListNode q = head;
		// 判断空链表
		if (head == null) {
			return head;
		}
		while (p != null) {
			if (n >= 0) {
				// p 向后移动，直到 n == 0 或者 p 为空
				p = p.next;
				n--;
			} else {
				// p和q都向后移动
				p = p.next;
				q = q.next;
			}
		}
		// 如果 n没有到 -1，那么需要把q向前移动
		if (n >= 0) {
			// 判断q.next是不是null，如果是，则表示删掉的是最后一个元素，那么直接把 q
			q = q.next;
		}
		ListNode temp = q == null ? null : q.next;
		if (q != null) {
			q.next = temp == null ? null : temp.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode tail = new ListNode(0);
		ListNode next1 = new ListNode(1, tail);
//		ListNode next2 = new ListNode(2, next1);
//		ListNode next3 = new ListNode(3, next2);
//		ListNode next4 = new ListNode(4, next3);
//		ListNode next5 = new ListNode(5, next4);
//		ListNode head = new ListNode(6, next5);


		ListNode result = removeNthFromEnd(tail, 1);
		while(null != result) {
			System.out.print(result.val);
			System.out.print(" -> ");
			result = result.next;
		}
	}
}
