package easy;

import utils.TreeNode;

public class BSTMinDistance {
    private int min = Integer.MAX_VALUE;
    private int last = -1;
    public int minDiffInBST(TreeNode root) {
        inTraverse(root);
        return min;
    }

    private void inTraverse(TreeNode root) {
        if(root.left != null){
            inTraverse(root.left);
        }
        if(last >= 0){
            min = Math.min(min, root.val - last);
        }
        last = root.val;
        if(root.right != null){
            inTraverse(root.right);
        }
    }
}
