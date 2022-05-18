package hard;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *  
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *  
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution_4 {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// 合并两个数组
		int length = nums1.length + nums2.length;
		int[] nums = new int[length];
		// 开始双指针遍历
		int m = 0;
		int n = 0;
		int i = 0;
		while (m < nums1.length && n < nums2.length) {
			if (nums1[m] <= nums2[n]) {
				// 左边比右边小，则记录左边的值，并让左边向前移动
				nums[i] = nums1[m];
				m++;
			} else {
				nums[i] = nums2[n];
				n++;
			}
			i++;
		}
		// 收尾
		for (; m < nums1.length; m++, i++) {
			nums[i] = nums1[m];
		}
		for (; n < nums2.length; n++, i++) {
			nums[i] = nums2[n];
		}
		// 计算中位数
		int mid = (i - 1) / 2;
		if (i % 2 == 0) {
			// 双数
			return nums[mid] + (nums[mid + 1] - nums[mid]) / 2.0;
		} else {
			// 单数
			return nums[mid];
		}
	}

	public static void main(String[] args) {
		int[] nums1 = new int[]{1};
		int[] nums2 = new int[]{3, 4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
