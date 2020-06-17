package easy;

import utils.TreeNode;

public class BTreeTilt {
    int result = 0;
    public int findTilt(TreeNode root) {
        traversePost(root);
        return result;
    }

    private int traversePost(TreeNode root) {
        if(root == null)return 0;
        int left = traversePost(root.left);
        int right = traversePost(root.right);
        result += Math.abs(left - right);
        return left + right + root.val;
    }
}
