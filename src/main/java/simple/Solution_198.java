package simple;

public class Solution_198 {

    /**
     *
     * @param args
     */
    public static void main ( String[] args ) {
        int[] testArray = {2,1,1,3};


        System.out.println (rob(testArray));


    }

    /**
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums){
        if(nums.length <= 0)
            return 0;
        if(nums.length == 1)
            return nums[0];

        int[] sums = new int[nums.length];

        sums[0] = nums[0];
        sums[1] = Math.max ( nums[0], nums[1] );
        for ( int i = 2; i < nums.length; i ++) {
//            // 2019.4.8 丹姐：这是最高级的判断偶数的方法
//            if((i & 1) == 0){
//                sumOfEven += nums[i];
//            } else {
//                sumOfOdd += nums[i];
//            }
            int temp = Math.max ( sums[i - 1], sums[i - 2] + nums[i] );
            sums[i] = temp;
        }
        return sums[nums.length - 1];
    }
}
