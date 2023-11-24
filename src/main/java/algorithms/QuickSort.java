package algorithms;

import java.util.Random;

public class QuickSort extends AbstractDemoSort {
	/**
	 * 快速排序，asc
	 *
	 * @param nums 数组
	 */
	@Override
	public void sort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}

	/**
	 * 对 nums[left, right] 区间内的元素进行快速排序
	 *
	 * @param nums  数组
	 * @param left  左下标
	 * @param right 右下标
	 */
	private void quickSort(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		int p = partition(nums, left, right);
		quickSort(nums, left, p - 1);
		quickSort(nums, p + 1, right);
	}

	/**
	 * 对 nums[left, right] 区间内的元素进行分割排序
	 *
	 * @param nums  数组
	 * @param left  左下标
	 * @param right 右下标
	 * @return 分割点
	 */
	private int partition(int[] nums, int left, int right) {
		// 随机交换一个坐标的值到最左端
		Random random = new Random();
		int randomIndex = random.nextInt(right - left) + left;
		swapArray(nums, left, randomIndex);

		int temp = nums[left];
		int jndex = left;
		// 开始遍历
		for (int index = left + 1; index <= right; index++) {
			if (nums[index] < temp) {
				// 交换 i 和 j + 1
				swapArray(nums, jndex + 1, index);
				jndex++;
			}
		}
		// 交换 left 和 j
		swapArray(nums, left, jndex);
		return jndex;
	}
}
