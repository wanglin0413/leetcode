package easy;

import utils.Node;

public class NaryMaxDepth {
    public int maxDepth(Node root) {
        if(root == null)return 0;
        int childD = 0;
        for(Node child : root.children){
            childD = Math.max(maxDepth(child), childD);
        }
        return childD+1;
    }

}
