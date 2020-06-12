package easy;

import utils.MainClass;
import utils.TreeNode;

public class DiameterOfBT {
    //求二叉树的直径
    //直径定义：二叉树中任何两个节点间的最长path的长度，可以不经过root
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        postTraverse(root);
        return max;
    }

    private int postTraverse(TreeNode root) {
        if(root == null)return 0;
        int left = postTraverse(root.left);
        int right = postTraverse(root.right);
        if(left+right > max){
            max = left+right ;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = MainClass.stringToTreeNode("[1,2,3,4,5]");
        DiameterOfBT dbt = new DiameterOfBT();
        System.out.println(dbt.diameterOfBinaryTree(root));
    }
}
