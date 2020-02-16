package hard;

import easy.MainClass;
import easy.TreeNode;

public class BTMaxPathSum {
    // helper 统计当前root到左右单个path的最大值
    // maxSum 统计通过当前root的，加上左右两个path的总的最大值
    // maxSum 就是左右两个单path，再加上root的
    private int maxSum = 0;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;;
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;

        int val = helper(root);

        return Math.max(val, maxSum);
    }

    public int helper(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        if (root.left == null && root.right == null) return root.val;

        int leftSum = helper(root.left);
        int rightSum = helper(root.right);

        int maxLeftRight = Math.max(leftSum, rightSum);
        maxSum = Math.max(maxLeftRight, maxSum);

        int rootLeftRight = 0;
        int rootLeft = root.val;
        int rootRight = root.val;

        if (leftSum != Integer.MIN_VALUE) {
            rootLeft += leftSum;
            rootLeftRight += rootLeft;
        }
        if (rightSum != Integer.MIN_VALUE) {
            rootRight += rightSum;
            rootLeftRight += rootRight;
        }

        rootLeftRight -= root.val;

        maxSum = Math.max(maxSum, Math.max(rootLeftRight, Math.max(rootLeft, rootRight)));

        // return either the sum of root + right OR root + left OR only root
        return Math.max(root.val, Math.max(rootRight, rootLeft));
    }

    public static void main(String[] args) {
        TreeNode root = MainClass.stringToTreeNode("[10,-9,-20,null,null,-15,-7]");
        BTMaxPathSum btps = new BTMaxPathSum();
        System.out.println(btps.maxPathSum(root));
    }

}
