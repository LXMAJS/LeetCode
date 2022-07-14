package medium;

/**
 * 24. 两两交换链表中的节点
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 *
 */
public class Solution_24 {

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

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = head;
		ListNode q = head.next;
		int switchCount = 1;
		ListNode temp = null;
		do {
			if (switchCount % 2 == 1) {
				p.next = q.next;
				q.next = p;
			} else {
				q.next = p.next;
				p.next = q;
			}
			switchCount++;
			// p和q都向后移动2次
			if (p == null || p.next == null || p.next.next == null
					|| q == null || q.next == null || q.next.next == null) {
				break;
			} else {
				p = p.next.next;
				q = q.next.next;
			}
		} while (p == null || q == null);
		return head;
	}

	public static void main(String[] args) {


		ListNode tail = new ListNode(7);
		ListNode next1 = new ListNode(6, tail);
		ListNode next2 = new ListNode(5, next1);
		ListNode next3 = new ListNode(4, next2);
		ListNode next4 = new ListNode(3, next3);
		ListNode next5 = new ListNode(2, next4);
		ListNode list1 = new ListNode(1, next5);

		ListNode result = swapPairs(list1);
		while(null != result) {
			System.out.print(result.val);
			System.out.print("->");
			result = result.next;
		}
	}
}
