package easy;

public class PathSum {
    public int pathSum(TreeNode root, int sum) {
        return pathFrom(root, sum) + pathFrom(root.right, sum) + pathFrom(root.left, sum);
    }

    private int pathFrom(TreeNode root, int sum) {
        if(root == null) return 0;
        int count = 0;
        if(root.val == sum) count++;
        count += pathFrom(root.left, sum - root.val);
        count += pathFrom(root.right, sum - root.val);
        return count;
    }


    public static void main(String[] args) {
        PathSum ps = new PathSum();
        TreeNode root = MainClass.stringToTreeNode("[10,5,-3,3,2,null,11,3,-2,null,1]");
        System.out.println(ps.pathSum(root, 8));
    }
}
