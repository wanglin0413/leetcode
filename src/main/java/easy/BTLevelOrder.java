package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTLevelOrder {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int level = 0;
        traverseLevel(root, level, result);
        Collections.reverse(result);
        return result;
    }

    private void traverseLevel(TreeNode root, int level, List<List<Integer>> result) {
        if(root == null)return;
        if(level >= result.size()) result.add(level, new ArrayList<Integer>());
        result.get(level).add(root.val);
        level++;
        traverseLevel(root.left, level, result);
        traverseLevel(root.right, level, result);
    }

    public class TreeNode {
    int val;
   TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
}
