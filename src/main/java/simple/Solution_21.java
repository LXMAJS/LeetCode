package simple;

/**
 * 21. 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *

 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class Solution_21 {

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


	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode head = new ListNode();
		ListNode index = head;
		while(list1 != null || list2 != null) {
			if (list1 != null && list2 != null) {
				// 取一个较小的，并向后移
				if (list1.val <= list2.val) {
					index.next = new ListNode(list1.val);
					index = index.next;
					list1 = list1.next;
				} else {
					index.next = new ListNode(list2.val);
					index = index.next;
					list2 = list2.next;
				}
			} else if (list1 != null) {
				// 遍历l1，直到l1结束即可
				index.next = new ListNode(list1.val);
				index = index.next;
				list1 = list1.next;
			} else {
				index.next = new ListNode(list2.val);
				index = index.next;
				list2 = list2.next;
			}
		}
		return head.next;
	}


	public static void main(String[] args) {


		ListNode tail = new ListNode(6);
		ListNode next1 = new ListNode(5, tail);
		ListNode next2 = new ListNode(4, next1);
		ListNode next3 = new ListNode(4, next2);
		ListNode next4 = new ListNode(3, next3);
		ListNode next5 = new ListNode(3, next4);
		ListNode list1 = new ListNode(1, next5);


		ListNode list2 = new ListNode(2);

		ListNode result = mergeTwoLists(list1, list2);
		while(null != result) {
			System.out.print(result.val);
			System.out.print("->");
			result = result.next;
		}
	}
}
