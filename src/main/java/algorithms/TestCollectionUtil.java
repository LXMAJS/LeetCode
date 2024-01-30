package algorithms;

import java.util.Random;

/**
 * 测试集生成工具
 */
class TestCollectionUtil {

	/**
	 * 生成随机的测试集
	 * @param n 元素个数
	 * @param minVal 最小值
	 * @param maxVal 最大值
	 * @return 测试集
	 */
	private static int[] generateRandomArray(int n, int minVal, int maxVal) {
		int[] arr = new int[n];
		// 创建一个Random对象
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			// 生成一个范围在[min, max]内的随机数，并将其添加到数组中
			arr[i] = random.nextInt(maxVal - minVal + 1) + minVal;
		}
		return arr;
	}

	/**
	 * 测试排序算法
	 * 测试集：10000个元素，大小从 0 ~ 10000
	 * @param sort 排序算法
	 */
	private static void testSortTime(AbstractDemoSort sort) {
		int size = 10000;
		int minVal = 0;
		int maxVal = 10000;
		int[] nums = TestCollectionUtil.generateRandomArray(size, minVal, maxVal);
		// 获取当前时间（以纳秒为单位）
		long startTime = System.nanoTime();
		// 调用要测试的方法
		sort.sort(nums);
		// 获取当前时间（以纳秒为单位）
		long endTime = System.nanoTime();
		// 计算方法执行的时间（以纳秒为单位）
		long duration = (endTime - startTime);
		// 将纳秒转换为秒
		double seconds = duration / 1e9;
		// 打印耗时
		System.out.println(sort.getClass() + ": " + seconds + "s.");
	}

	/**
	 * 测试功能
	 * @param sort 排序算法
	 */
	private static void testFunction(AbstractDemoSort sort) {
		int size = 10;
		int minVal = 0;
		int maxVal = 100;
		int[] nums = TestCollectionUtil.generateRandomArray(size, minVal, maxVal);
		System.out.print("排序前：");
		for (int num : nums) {
			System.out.print(num + ",");
		}
		sort.sort(nums);
		System.out.println("");
		System.out.print("排序后：");
		for (int num : nums) {
			System.out.print(num + ",");
		}
	}


	public static void main(String[] args) {
//		testSortTime(new SelectionSort());
//		testSortTime(new InsertionSort());
//		testSortTime(new BubbleSort());
//		testFunction(new MergeSort());
//		testSortTime(new MergeSortBottomUp());
//		testSortTime(new QuickSort());
//		testFunction(new QuickSortTwoWays());
//		testSortTime(new QuickSortThreeWays());
		testFunction(new MaxHeapSort());
	}
}
