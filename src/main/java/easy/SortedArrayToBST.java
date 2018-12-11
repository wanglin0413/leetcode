package easy;


public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)return null;
        return createTree(nums, 0, nums.length -1);


    }

    private TreeNode createTree(int[] nums, int low, int high) {
        if(low > high)return null;
        if(low == high)return new TreeNode(nums[low]);
        int mid = (low+high)  >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums, low, mid-1);
        root.right = createTree(nums, mid+1, high);
        return root;
    }

    public static void main(String[] args) {
        SortedArrayToBST sab = new SortedArrayToBST();
        int[] testCase = new int[]{-10,-3,0,5,9};
        sab.sortedArrayToBST(testCase);
    }
}
