package simple;

public class Solution_88 {
    /**
     *
     * @param args
     */
    public static void main ( String[] args ) {

        int[] nums1 = new int[]{4,0,0,0,0,0};
        int[] nums2 = new int[]{1,2,3,5,6};

        merge ( nums1, 1, nums2, 5 );

        for (int i = 0; i < nums1.length; i ++){
            System.out.println (" " + nums1[i]);
        }
    }

    /**
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0) {
            return;
        }
        if(nums1 == null || nums2 == null) {
            return;
        }
        // 从两个数组的尾巴开始往前比较，把大的那个元素依次赋值到nums1末尾，直到把num1和num2都遍历完
        while(m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[--m];
            } else {
                nums1[m + n - 1] = nums2[--n];
            }
        }
        if (m > 0) {
            for (int i = m; i > 0; i--) {
                nums1[m - 1] = nums1[--m];
            }
        }
        if (n > 0) {
            for (int i = n; i > 0; i--) {
                nums1[n - 1] = nums2[--n];
            }
        }
    }
}
