package simple;

public class Solution_112 {

    /**
     * 节点
     */
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode ( int x ) {
            val = x;
        }
    }

    /**
     *
     * @param root
     * @param sum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int sum){
        if(root == null)
            return false;

        if(root.left == null && root.right == null){
            return sum - root.val == 0;
        }

        return hasPathSum ( root.left, sum - root.val ) || hasPathSum ( root.right, sum - root.val);
    }

}
