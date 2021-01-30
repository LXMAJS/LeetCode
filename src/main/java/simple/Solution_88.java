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
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0)
            return;
        if(nums1 == null || nums2 == null)
            return;

        if (m <= 0 || nums1[m - 1] <= nums2[0]) {
            // 如果数组1的最后一个元素，比数组2的元素还要小，那么不做任何处理，直接进入最后的合并环节
        } else {
            // 此处进行比对环节，将所有数组1中，比数组2大的数，依次替换到数组2中
            int index1 = 0, index2 = 0;
            int temp = 0;
            while (index1 < m && index2 < n) {
                if (nums1[index1] > nums2[index2]) {
                    temp = nums2[index2];
                    nums2[index2] = nums1[index1];
                    nums1[index1] = temp;
                    index2++;
                }
                index1++;
            }
        }
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }

        return;
    }
}
