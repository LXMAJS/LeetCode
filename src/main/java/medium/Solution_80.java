package medium;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 *
 *
 * 说明：
 *
 * 为什么返回数值是整数，但输出的答案是数组呢？
 *
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,1,2,2,3]
 * 输出：5, nums = [1,1,2,2,3]
 * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,1,1,2,3,3]
 * 输出：7, nums = [0,0,1,1,2,3,3]
 * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
 */
public class Solution_80 {

	/**
	 * 删除数组中重复的元素
	 *
	 * @param nums 数组
	 * @return 删除后的数组大小
	 */
	private static int removeDuplicates(int[] nums) {
		// 如果数组的大小 小于1，那么可以优先判断
		if (nums.length <= 1) {
			return nums.length;
		}
		// 定义双指针
		int j = 0;
		int count = 0;
		// 执行循环判断
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[j]) {
				// 如果前后两个数不相等，或当前数字出现的次数超过2次
				nums[++j] = nums[i];
				count = 0;
			} else if (nums[i] == nums[j]) {
				count++;
				if (count < 2) {
					nums[j+1] = nums[j++];
				}
			}
		}
		return ++j;
	}

	public static void main(String[] args) {
		int[] nums = {0, 0, 0, 1, 1, 1, 1, 2, 2, 3, 3, 3, 4};
		System.out.println(removeDuplicates(nums));
		System.out.println("数组元素：");
		for (int num : nums) {
			System.out.print(num);
		}
	}
}
