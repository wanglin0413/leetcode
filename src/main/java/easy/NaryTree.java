package easy;

import java.util.ArrayList;
import java.util.List;

public class NaryTree {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        int level = 0;
        traversal(root, level, result);
        return result;
    }

    private void traversal(Node root, int level, List<List<Integer>> result) {
        if(root != null){
            if(result.get(level) == null){
                result.add(level, new ArrayList<>());
            }
            result.get(level).add(root.val);
        }
        for(Node each : root.children){
            traversal(each, level + 1, result);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

}
