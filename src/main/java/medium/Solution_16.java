package medium;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_16 {

	public static int threeSumClosest(int[] nums, int target) {
		if (nums.length <= 2) {
			return 0;
		}
		// 首先排序
		Arrays.sort(nums);
		// 开始循环
		for (int first = 0; first < nums.length - 2; first ++) {
			int left = first + 1;
			int right = left + 1;
			// 求差
			int remain = target - nums[first];

		}


		return 0;
	}

	public static void main(String[] args) {

	}
}
