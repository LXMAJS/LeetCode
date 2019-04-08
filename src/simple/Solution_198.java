package simple;

public class Solution_198 {

    /**
     *
     * @param args
     */
    public static void main ( String[] args ) {
        int[] testArray = {2,7,9,3,1};


        System.out.println (rob(testArray));


    }

    /**
     *
     * @param nums
     * @return
     */
    public static int rob(int[] nums){
        int sumOfOdd = 0;
        int sumOfEven = 0;
        for ( int i = 0; i < nums.length; i ++){
            // 2019.4.8 丹姐：这是最高级的判断偶数的方法
            if((i & 1) == 0){
                sumOfEven += nums[i];
            } else {
                sumOfOdd += nums[i];
            }
        }
        return sumOfOdd > sumOfEven ? sumOfOdd : sumOfEven;
    }
}
