package medium;

public class UBSTCount {
    public int numTrees(int n) {
        if(n <= 1)return 1;
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 2; i<=n; i++){
            for(int j = 1; j <= i; j++){
                nums[i] += (nums[j-1] * nums[i-j]);
            }

        }
        return nums[n];
    }
// 动态规划计算
    // 对于一个n，可以有1，2，。。。n分别为根 G（n） = root(1,n)+root(2,n)+...root(n,n)
    //root(i, n) 有两个子树，G(i-1) G(n-i)，总共有G（i-1）*G(n-i)（这里不用在意树的节点数字是什么，只需要考虑节点个数）
    //用一个数组记录已经计算过的G（n），避免重复计算
}
