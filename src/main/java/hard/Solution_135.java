package hard;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 *
 * 示例 1：
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 *
 * 示例 2：
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *
 *
 * 提示：
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 */
public class Solution_135 {

//	public int candy(int[] ratings) {
//		int preVal = 0;
//		int min = 0;
//		int sum = 0;
//		// 循环给candy赋值
//		for (int i = 1; i < ratings.length; i++) {
//			int curVal = ratings[i] > ratings[i - 1] ? ++preVal : --preVal;
//			// 判断最小值
//			if (curVal < min) {
//				min = curVal;
//			}
//			// 求和
//			sum += curVal;
//			preVal = curVal;
//		}
//		sum += (Math.abs(min) + 1) * ratings.length;
//		return sum;
//	}

	public int candy(int[] ratings) {
		// 糖果总和
		int sum = 1;
		// 上一个同学分到的糖果
		int pre = 1;
		// 升序数组的长度
		int inc = 1;
		// 降序数组的长度
		int dec = 0;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] >= ratings[i - 1]) {
				pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
				sum += pre;
				// 升序数组的长度一直和当前同学分到的糖果数相等
				inc = pre;
				// 升序数组中，降序数组的长度一直是0
				dec = 0;
			} else {
				dec++;
				// 预判，如果当前是降序数组，并且执行到这一步时，
				// 当前同学能分到的糖果数（pre - 1) 是 0，
				// 则表示需要给之前降序数组中的每一个同学都补上一个糖果，
				// 这样当前同学才能拿到1个糖果
				if (inc == dec) {
					// 用 inc == pre 来代替 pre - 1 <= 0 的判断
					dec ++;
				}
				sum += dec;
				pre = 1;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] rating = new int[]{1, 3, 2, 2, 1};
		System.out.println(new Solution_135().candy(rating));
	}
}
