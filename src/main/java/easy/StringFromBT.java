package easy;

import utils.MainClass;
import utils.TreeNode;

public class StringFromBT {

    public String tree2str(TreeNode t) {
        if(t == null)return "";
        StringBuilder sb = new StringBuilder();
        preOrder(t, sb);
        return sb.toString();
    }

    private void preOrder(TreeNode t, StringBuilder sb) {
        sb.append(t.val);
        if(t.left != null || t.right != null){
            if(t.left != null){
                sb.append("(");
                preOrder(t.left, sb);
                sb.append(")");
            }else {
                sb.append("()");
            }
            if(t.right != null){
                sb.append("(");
                preOrder(t.right, sb);
                sb.append(")");
            }
        }
    }

    public static void main(String[] args) {
        String bst = "[1,2,3,null,4]";
        TreeNode root = MainClass.stringToTreeNode(bst);
        StringFromBT sbt = new StringFromBT();
        System.out.println(sbt.tree2str(root));
    }
}
