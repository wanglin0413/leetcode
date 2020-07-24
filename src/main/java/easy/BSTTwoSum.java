package easy;

import utils.MainClass;
import utils.TreeNode;

public class BSTTwoSum {
    public boolean findTarget(TreeNode root, int k) {
        return findTarget(root, root, k);

    }

    private boolean findTarget(TreeNode root, TreeNode bst, int k) {
        if(root == null)return false;
        int diff = k - root.val;
        if(findK(bst, root.val, diff))return true;
        if(findTarget(root.left, bst, k))return true;
        return findTarget(root.right, bst, k);
    }

    private boolean findK(TreeNode root, int rootVal, int val) {
        if(root == null)return false;
        if(root.val == val && root.val != rootVal)return true;
        if(root.val > val){
            return findK(root.left, rootVal, val);
        }else {
            return findK(root.right, rootVal, val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = MainClass.stringToTreeNode("[2,1,3]");
        BSTTwoSum bts = new BSTTwoSum();
        System.out.println(bts.findTarget(root, 4));
    }
}
