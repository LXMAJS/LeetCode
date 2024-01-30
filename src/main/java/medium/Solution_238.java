package medium;

/**
 * 238. 除自身以外数组的乘积
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 *
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 */
public class Solution_238 {
	public static int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];

		// left[i] 表示 [0-i] 的乘积
		left[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			left[i] = left[i - 1] * nums[i];
		}
//		System.out.print("\nleft:");
//		for (int i1 : left) {
//			System.out.print(i1 + ",");
//		}

		// right[i] 表示 [i-nums.len] 的乘积
		right[nums.length - 1] = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			right[i] = right[i + 1] * nums[i];
		}
//		System.out.print("\nright:");
//		for (int i1 : right) {
//			System.out.print(i1 + ",");
//		}

		// 新增一个数组，answer[i] = left[i-1] * right[i]
		int[] answer = new int[nums.length];
		answer[0] = right[1];
		for (int i = 1; i < left.length - 1; i++) {
			answer[i] = left[i - 1] * right[i + 1];
		}
		answer[nums.length - 1] = left[nums.length - 2];

//		System.out.print("\nanswer:");
//		for (int i1 : answer) {
//			System.out.print(i1 + ",");
//		}
		return answer;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{1,2};
		productExceptSelf(nums);
	}

}
