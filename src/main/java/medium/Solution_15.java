package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @date 2022-03-28
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_15 {

	/**
	 * 计算三个数的和等于0
	 * @param nums 数字
	 * @return 返回
	 */
	private static List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length <= 2) {
			return new ArrayList<>();
		}
		// 排序
		Arrays.sort(nums);
		// 开始计算
		List<List<Integer>> list = new ArrayList<>();
		for (int index = 0; nums[index] <= 0 && index < nums.length - 1; index ++) {
			// 跳过当前值和下一个值相等的index
			if (index > 0 && nums[index - 1] == nums[index]) {
				continue;
			}
			int left = index + 1;
			int right = nums.length - 1;
			int sum = 0;
			while (left < right) {
				sum = nums[index] + nums[left] + nums[right];
				if (sum > 0) {
					// 说明右边的数字大了，向左移动
					do { right--; }
					while (right > left && nums[right + 1] == nums[right]);
				} else if (sum < 0) {
					// 如果小于0，说明左值偏小，向右移动
					do { left++; }
					while (left < right && nums[left - 1] == nums[left]);
				} else {
					// 终于找到等于0的了，那么就加入到临时的列表中
					List<Integer> tempList = new ArrayList<>();
					tempList.add(nums[index]);
					tempList.add(nums[left]);
					tempList.add(nums[right]);
					list.add(tempList);

					do { right--; }
					while (right > left && nums[right + 1] == nums[right]);

					do { left++; }
					while (left < right && nums[left - 1] == nums[left]);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{-2,0,1,1,2};
		System.out.println(threeSum(nums));
	}
}
