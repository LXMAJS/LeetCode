package algorithms;

public class SelectionSort extends AbstractDemoSort {
	/**
	 * 选择排序，asc
	 * @param nums 数组
	 */
	@Override
	public void sort(int[] nums) {
		if (nums.length <= 1) {
			return;
		}
		// 外层循环
		for (int index = 0; index < nums.length; index++) {
			int minIndex = index;
			// 内层循环
			for (int jndex = index + 1; jndex < nums.length; jndex++) {
				if (nums[jndex] < nums[minIndex]) {
					minIndex = jndex;
				}
			}
			swapArray(nums, index, minIndex);
		}
	}
}
