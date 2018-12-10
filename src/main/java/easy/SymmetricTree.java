package easy;

public class SymmetricTree {
    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
}
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null)return true;
        if(left == null)return false;
        if(right == null)return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left) && left.val == right.val;
    }

}
