package easy;

import utils.MainClass;
import utils.TreeNode;

public class SecondMin {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        if (root.left != null) {

            if(root.left.val != root.right.val){
                if(root.right.val > root.left.val){
                    int result1 = findSecondMinimumValue(root.left);
                    if(result1 == -1)return root.right.val;
                    return Math.min(result1, root.right.val);
                }else {
                    int result2 = findSecondMinimumValue(root.right);
                    if(result2 == -1)return root.left.val;
                    return Math.min(result2, root.left.val);
                }
            }else {
                int result1 = findSecondMinimumValue(root.left);
                int result2 = findSecondMinimumValue(root.right);
                if (result1 != -1 && result2 != -1) {
                    return Math.min(result1, result2);
                } else if (result1 != -1) {
                    return result1;
                } else if (result2 != -1) {
                    return result2;
                }
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = MainClass.stringToTreeNode("[1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]");
        SecondMin sm = new SecondMin();
        System.out.println(sm.findSecondMinimumValue(root));
    }
}
