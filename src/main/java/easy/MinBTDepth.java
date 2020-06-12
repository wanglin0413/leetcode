package easy;

import utils.TreeNode;

public class MinBTDepth {
    public int minDepth(TreeNode root) {
        if(root == null)return 0;
        if(root.left == null && root.right == null)return 1;
        if(root.right == null)return minDepth(root.left)+1;
        if(root.left == null)return minDepth(root.right)+1;
        return Math.min(minDepth(root.right)+1, minDepth(root.left)+1);
    }
}
