package simple;

import java.util.Arrays;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 */
public class Solution_169 {
	/**
	 * 排序法
	 * @param nums 数组
	 * @return 众数
	 */
	public static int majorityElement1(int[] nums) {
		// 先排序
		Arrays.sort(nums);
		// 再取出数组中间的那个数字。数组长度向右移动1位，在数学中表示除以2
		return nums[nums.length >> 1];
	}

	public static int majorityElement2(int[] nums) {
		if (nums.length <= 1) {
			return nums.length <= 0 ? -1 : nums[0];
		}
		int tempNum = nums[0];
		int count = 1;
		for (int num : nums) {
			if (num == tempNum) {
				count++;
			} else {
				count --;
			}
			if (count <= 0) {
				tempNum = num;
				count = 1;
			}
		}
		return tempNum;
	}
}
