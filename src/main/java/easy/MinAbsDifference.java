package easy;

import utils.MainClass;

public class MinAbsDifference {
    private int sbsDiff = Integer.MAX_VALUE;
    Integer cur = null;
    public int getMinimumDifference(TreeNode root) {
        inTraverse(root);
        return sbsDiff;
    }

    private void inTraverse(TreeNode root) {
        if(root == null)return;
        inTraverse(root.left);
        if(cur != null){
            sbsDiff = Math.min(sbsDiff, root.val - cur);
        }
        cur = root.val;
        inTraverse(root.right);

    }

    public static void main(String[] args) {
        TreeNode root = MainClass.stringToTreeNode("[236,104,701,null,227,null,911]");
        MinAbsDifference mad = new MinAbsDifference();
        System.out.println(mad.getMinimumDifference(root));
    }
}
