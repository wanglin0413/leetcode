package easy;


import utils.TreeNode;

public class BalancedBT {
    //平衡树的定义：左右子树的高度差不大于1
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        int left = length(root.left);
        int right = length(root.right);
        int diff = Math.abs(left - right);
        return diff<=1 && isBalanced(root.right) && isBalanced(root.left);
    }

    private int length(TreeNode root){
        if(root == null)return 0;
        return Math.max(length(root.left)+1, length(root.right)+1);
    }



}
