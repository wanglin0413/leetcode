package unclissified; /**
 * Created by wanglin03 on 2017/9/27.
 */

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BTPostOrder {
    public class TreeNode {
        TreeNode(int x) {
            val = x;
        }
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> valueStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            valueStack.push(node.val);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        List<Integer> answers = new ArrayList<>();
        while (!valueStack.isEmpty()){
            answers.add(valueStack.pop());
        }
        return answers;
    }

    public static void main(String[] args){
        BTPostOrder postOrder = new BTPostOrder();
        BTPostOrder.TreeNode root = postOrder.new TreeNode(1);
        root.right = postOrder.new TreeNode(2);
        root.right.left = postOrder.new TreeNode(3);
        List<Integer> answer = postOrder.postorderTraversal(root);
        System.out.print(answer.toString());
    }
}

