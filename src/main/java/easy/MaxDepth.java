package easy;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int depth = 0;
        return maxDepth(root, depth);
    }

    private int maxDepth(TreeNode root, int depth) {
        if(root == null)return depth;
        depth++;
        return Math.max(maxDepth(root.left, depth), maxDepth(root.right, depth));
    }

    public class TreeNode {
     int val;
     TreeNode left;
    TreeNode right;
     TreeNode(int x) { val = x; }
 }
}
