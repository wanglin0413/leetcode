package easy;

import utils.MainClass;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelInBT {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>result = new ArrayList<>();
        if(root == null)return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelCount = queue.size();
            double valSum = 0;
            for(int i =0; i< levelCount; i++){
                TreeNode one = queue.poll();
                valSum += one.val;
                if(one.right != null) {
                    queue.offer(one.right);
                }
                if(one.left != null) {
                    queue.offer(one.left);
                }
            }
            result.add(valSum/levelCount);

        }

        return result;
    }

    public static void main(String[] args) {
        AverageOfLevelInBT albt = new AverageOfLevelInBT();
        TreeNode root = MainClass.stringToTreeNode("[3,9,20,null,null,15,7]");
        System.out.println(albt.averageOfLevels(root));
    }
}
