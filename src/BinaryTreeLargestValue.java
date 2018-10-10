import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLargestValue {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }



    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)return result;
        result.add(root.val);
        int level = 2;
        iterateTree(root.left, result, level);
        iterateTree(root.right, result, level);
        return result;
    }

    private void iterateTree(TreeNode root, List<Integer> result, int level) {
        if(root == null)return;
        if(result.size() < level){result.add(level-1, root.val);}
        else if(result.get(level-1) < root.val){
           result.set(level -1, root.val);
       }
       iterateTree(root.left, result, level + 1);
       iterateTree(root.right, result, level + 1);
    }

}
