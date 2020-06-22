package easy;

import utils.MainClass;
import utils.TreeNode;

public class SubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null)return true;
        if(s == null || t == null)return false;
        if(isSameTree(s, t)){
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if(s == null && t == null)return true;
        if(s == null || t == null)return false;
        if(s.val != t.val)return false;
        return isSameTree(s.right, t.right) && isSameTree(s.left, t.left);
    }

    public static void main(String[] args) {
        TreeNode s = MainClass.stringToTreeNode("[3,4,5,1,2,null,null,0]");
        TreeNode t = MainClass.stringToTreeNode("[4,1,2]");
        SubTree st = new SubTree();
        System.out.println(st.isSubtree(s, t));
    }
}
