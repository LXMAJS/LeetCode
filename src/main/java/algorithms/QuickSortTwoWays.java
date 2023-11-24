package algorithms;

import java.util.Random;

public class QuickSortTwoWays extends AbstractDemoSort {
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
	// nums[left, i]
	int i = left + 1;
	int j = right;
	while (true) {
		while (i <= right && nums[i] < temp) {
			// nums[left + 1, i) <= temp
			i ++;
		}
		while (j >= left + 1 && nums[j] > temp) {
			// nums(j, right] <= temp
			j --;
		}
		// 如果循环到头了，就结束
		if (i > j) {
			break;
		}
		// 上面的两个while结束，表示需要交换数组位置
		swapArray(nums, i, j);
		// 继续触发循环
		i ++;
		j --;
	}
	// 最后，把temp放到整理好的数组中
	swapArray(nums, left, j);
	return j;
}
}
