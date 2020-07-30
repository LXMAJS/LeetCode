package simple;

import java.util.HashMap;
import java.util.Map;

public class Solution_1 {
    /**
     *
     * @param args
     */
    public static void main ( String[] args ) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] res = twoSum2(nums, target);
        System.out.println(res);
    }

    private static int[] twoSum(int[] nums, int target) {
        if (null == nums || nums.length <= 0) {
            return null;
        }
        for (int index = 0; index < nums.length; index++) {
            for (int jndex = index + 1; jndex < nums.length; jndex++) {
                if ((target - nums[index]) == nums[jndex]) {
                    return new int[]{index, jndex};
                }
            }
        }
        return null;
    }

    private static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> tmp = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            int num = target - nums[index];
            if (tmp.containsKey(num)) {
                return new int[]{tmp.get(num), index};
            }
            tmp.put(nums[index], index);
        }
        return null;
    }

}
