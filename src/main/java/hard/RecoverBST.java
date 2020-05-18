package hard;

import utils.MainClass;
import easy.TreeNode;

public class RecoverBST {
    //BST的中序遍历，应该是有序的
    //有两个交换了，则中序遍历结果中，有两个逆序对
    //找到第一个逆序对的前一个，第二个逆序对的后一个，交换即可
    //遍历BST，root是有序序列中的cur节点，prev是有序序列中cur的前一个，对比找到逆序对
    public TreeNode first;
    public TreeNode sec;
    public TreeNode prev;
    public void recover(TreeNode root) {
        if (root == null) return;
        // go to left side
        recover(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            sec = root;
        }
        prev = root;
        // go to right side
        recover(root.right);
    }
    public void recoverTree(TreeNode root) {
        recover(root);
        // swap the nodes
        if (first != null) {
            int tmp = first.val;
            first.val = sec.val;
            sec.val = tmp;
        }
    }

    public static void main(String[] args) {
        TreeNode root = MainClass.stringToTreeNode("[3,1,4,null,null,2]");
        RecoverBST recoverBST = new RecoverBST();
        recoverBST.recoverTree(root);
    }
}
