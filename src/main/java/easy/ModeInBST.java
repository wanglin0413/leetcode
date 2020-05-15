package easy;

import utils.MainClass;

import java.util.ArrayList;
import java.util.List;

public class ModeInBST {

    Integer tmp = null;
    int count = 0;
    int max = 0;
    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        if(root == null)return new int[0];
        preTraverse(root);
        max = Math.max(max, count);
        tmp = null;
        preTraverse2(root);
        if(count == max){
            result.add(tmp);
        }
        int[] intResult = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            intResult[i] = result.get(i);
        }
        return intResult;
    }

    private void preTraverse2(TreeNode root) {
        if(root == null)return;
        preTraverse2(root.left);
        if(tmp == null){
            tmp = root.val;
            count = 1;
        }else if(tmp == root.val){
            count+=1;
        }else {
            if(count == max)result.add(tmp);
            tmp = root.val;
            count = 1;
        }
        preTraverse2(root.right);
    }

    private int preTraverse(TreeNode root) {
        if(root == null)return max;
        preTraverse(root.left);
        if(tmp == null){
            tmp = root.val;
            count = 1;
        }else if(tmp == root.val){
            count+=1;
        }else {
            tmp = root.val;
            if(count > max)max = count;
            count = 1;
        }
        preTraverse(root.right);
        return max;
    }

    public static void main(String[] args) {
        ModeInBST modeInBST = new ModeInBST();
        TreeNode tree = MainClass.stringToTreeNode("[2147483647]");
        modeInBST.findMode(tree);
    }
}
