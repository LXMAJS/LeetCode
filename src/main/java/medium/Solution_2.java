package medium;

import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution_2 {

	/**
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode root = new ListNode(0);
		ListNode index = root;
		int overflow = 0;
		while (l1 != null || l2 != null || overflow != 0) {
			int l1Val = l1 != null ? l1.val : 0;
			int l2Val = l2 != null ? l2.val : 0;
			// 计算值
			int result = l1Val + l2Val + (overflow > 0 ? 1 : 0);
			overflow = result / 10; // 减11，若等于0，表示刚好是10
			ListNode node = new ListNode(result % 10);
			// 将下一个节点赋值给游标
			index.next = node;
			// 将游标赋值为节点
			index = node;
			if (l1 != null && l1.next != null) {
				l1 = l1.next;
			} else {
				l1 = null;
			}
			if (l2 != null && l2.next != null) {
				l2 = l2.next;
			} else {
				l2 = null;
			}
		}
		return root.next;
	}


	public static void main(String[] args) {
		LinkedList<Integer> q1 = new LinkedList<>();
		q1.add(2);
		q1.add(4);
		q1.add(3);

		LinkedList<Integer> q2 = new LinkedList<>();
		q2.add(5);
		q2.add(6);
		q2.add(4);
		q2.add(7);

		ListNode l1 = ListNode.makeListNode(q1);
		l1.print();

		ListNode l2 = ListNode.makeListNode(q2);
		l2.print();

		ListNode root = addTwoNumbers(l1, l2);
		root.print();

	}

	static class ListNode {
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

		static ListNode makeListNode(Queue<Integer> list) {
			if (null == list || list.isEmpty()) {
				return null;
			}
			ListNode root = new ListNode(list.poll());
			makeListNode(root, list);
			return root;
		}

		private static void makeListNode(ListNode parent, Queue<Integer> list) {
			if (null == list || list.isEmpty()) {
				return;
			}
			ListNode node = new ListNode(list.poll());
			makeListNode(node, list);
			parent.next = node;
		}

		void print() {
			System.out.print(val);
			if (null != next) {
				System.out.print("->");
				next.print();
			}
		}
	}
}
