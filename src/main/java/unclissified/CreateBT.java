package unclissified;

/**
 * Created by wanglin03 on 2017/10/23.
 */
public class CreateBT {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        TreeNode root = buildOneTree(preorder, inorder, 0, 0, preorder.length - 1);
        return root;
    }

    private TreeNode buildOneTree(int[] preorder, int[] inorder, int preBegin, int inBegin, int inEnd) {
        if (preBegin >= preorder.length || inBegin >= preorder.length) return null;
        if(inEnd < 0) return null;
        if (inBegin > inEnd) return null;
        if (inBegin == inEnd) return new TreeNode(preorder[preBegin]);
        TreeNode root = new TreeNode(preorder[preBegin]);
        int indexOfRoot = inBegin;
        while (inorder[indexOfRoot] != preorder[preBegin] && indexOfRoot < inEnd) {
            indexOfRoot++;
        }
        root.left = buildOneTree(preorder, inorder, preBegin + 1, inBegin, indexOfRoot - 1);
        root.right = buildOneTree(preorder, inorder, preBegin + indexOfRoot-inBegin+1, indexOfRoot + 1, inEnd);
        return root;
    }
    int preIdx = 0, inIdx = 0;

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode buildTree(int[] pre, int[] in, int rootValue) {
//        System.out.println(Arrays.toString(pre));
//        System.out.println(Arrays.toString(in));
        System.out.println(rootValue);
        //如果中序到最后了，说明遍历完了
        //如果中序到root了，说明该右子树了
        if (inIdx == in.length || in[inIdx] == rootValue) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preIdx]);
        //在中序index到最左边最底下的节点之前，一直是左子树
        preIdx++;
        node.left = buildTree(pre, in, node.val);
        //inorder 永远是当前root的子树下的最左最下节点
        inIdx++;
        node.right = buildTree(pre, in, rootValue);
        return node;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1,2};
        int[] in = new int[]{1,2};
        CreateBT bt = new CreateBT();
        TreeNode root = bt.buildTree1(pre, in);
    }

}
