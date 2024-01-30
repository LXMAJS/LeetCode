package medium;

/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class Solution_189 {
	/**
	 * 将数组向右移动k个位置
	 *
	 * @param nums 数组
	 * @param k    移动游标
	 */
	private static void rotate(int[] nums, int k) {
		reverse(nums, k);
	}

	/**
	 * merge
	 */
	private static void merge(int[] nums, int k) {
		k = k >= nums.length ? k % nums.length : k;
		if (k == 0) {
			return;
		}
		// 使用merge的方式来解答，首先使用临时数组来存储向右移动的这部分
		int[] tempNums = new int[k];
		for (int i = 0, j = nums.length - k; i < k; i++, j++) {
			tempNums[i] = nums[j];
		}
		// 合并两个数组
		int j = nums.length - 1;
		for (int i = nums.length - k - 1; i >= 0; i--, j--) {
			nums[j] = nums[i];
		}
		for (int i = k - 1; i >= 0; i--, j--) {
			nums[j] = tempNums[i];
		}
	}

	/**
	 * 冒泡
	 */
	private static void reverse(int[] nums, int k) {
		k = k >= nums.length ? k % nums.length : k;
		if (k == 0) {
			return;
		}
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}
	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start += 1;
			end -= 1;
		}
	}


	public static void main(String[] args) {

	}
}
