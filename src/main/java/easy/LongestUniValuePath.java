package easy;

import utils.MainClass;
import utils.TreeNode;

public class LongestUniValuePath {
    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        arrowPath(root);
        return max;
    }

    private int arrowPath(TreeNode root) {
        if (root == null) return 0;
        int left = arrowPath(root.left);
        int right = arrowPath(root.right);
        int arrowLeft = 0;
        int arrowRight = 0;
        if (root.left != null &&  root.left.val == root.val) {
            arrowLeft = left +1;
        }
        if(root.right != null && root.right.val == root.val){
            arrowRight = right + 1;
        }
        max = Math.max(max, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

    public static void main(String[] args) {
        LongestUniValuePath luvp = new LongestUniValuePath();
        TreeNode root = MainClass.stringToTreeNode("[1,4,5,4,4,5]");
        System.out.println(luvp.longestUnivaluePath(root));
    }
}
