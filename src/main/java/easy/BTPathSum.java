package easy;

import utils.TreeNode;

public class BTPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)return false;
        if(root.left == null && root.right == null)return sum == root.val;
        sum -= root.val;
        if(root.right ==null)return hasPathSum(root.left, sum);
        if(root.left == null)return hasPathSum(root.right, sum);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

}
