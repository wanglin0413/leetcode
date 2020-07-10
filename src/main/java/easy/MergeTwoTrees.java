package easy;

import utils.MainClass;
import utils.TreeNode;

public class MergeTwoTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)return null;
        if(t1 == null)return t2;
        if(t2 == null)return t1;
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public static void main(String[] args) {
        TreeNode t1 = MainClass.stringToTreeNode("[1,3,2,5]");
        TreeNode t2 = MainClass.stringToTreeNode("[2,1,3,null,4,7]");
        MergeTwoTrees mtt = new MergeTwoTrees();
        TreeNode result = mtt.mergeTrees(t1, t2);
        System.out.println("");
    }
}
