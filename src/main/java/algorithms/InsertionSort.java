package algorithms;

/**
 * 插入排序
 */
public class InsertionSort extends AbstractDemoSort {

	@Override
	public void sort(int[] nums) {
		sort2(nums);
	}

	/**
	 * 基础版本：交换位置
	 * @param nums 数组
	 */
	private void sort1(int[] nums) {
		if (nums.length <= 1) {
			return;
		}
		// 外层循环从第2个元素开始
		for (int index = 1; index < nums.length; index++) {
			// 里层循环当前元素开始向前比较
			for (int jndex = index; jndex > 0 && nums[jndex] < nums[jndex - 1]; jndex--) {
				swapArray(nums, jndex, jndex - 1);
			}
		}
	}

	/**
	 * 基础版本：值改写
	 * @param nums 数组
	 */
private void sort2(int[] nums) {
	if (nums.length <= 1) {
		return;
	}
	// 外层循环从第2个元素开始
	for (int index = 1; index < nums.length; index++) {
		int tempVal = nums[index];
		int jndex = index;
		// 里层循环当前元素开始向前比较
		for (; jndex > 0 && nums[jndex - 1] > tempVal; jndex--) {
			nums[jndex] = nums[jndex - 1];
		}
		nums[jndex] = tempVal;
	}
}
}
