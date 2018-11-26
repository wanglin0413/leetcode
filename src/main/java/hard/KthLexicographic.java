package hard;


public class KthLexicographic {
    public int findKthNumber(int n, int k) {
        //一个数组保存各个位上的数字
        //顺序为最后一位开始，从0-n，然后倒数第二位从0-n
        //根据k来确定各个位上的最大值
        if(n < 10){
            return k;
        }
       //各个位的数字为[1,0,5,0]
        //不能超过n
        //s位数，s层的十叉树，先从左到右深度优先数，直到某个数大于等于n后，还不到k，就往上一层s-1，但是不能再往下回到s层了
        //如果s-1层的第一个节点的所有子节点都遍历完了，还不大于n，那么回到s-1，下一个数，接着回s层遍历
        int cur = 1;
        k--;
        //计算cur 到cur+1有多少steps，如果steps > k, 则 cur*=10，下一层；如果 steps < k， 则cur +=1， k-=steps
        while (k > 0){
            int steps = calculate_steps(cur, n);
            System.out.println("cur: " + cur +", steps: " + steps + ", k: "+k);
            if(steps <= k){
                cur +=1;
                k -= steps;
            }else {
                cur*=10;
                k--;//需不需要--？？
            }
        }
        return cur;
    }

    private int calculate_steps(long cur, int n) {
        long next = cur+1;
        int steps = 0;
        //按层来计算
        //从上到下，cur 和 next = cur+1 只有一个
        //下一层，cur*=10， next*=10，如果next>n,这一层就是next-cur个，否则，就是n-cur+1个；
        //再下一层，同理
        //每一层的数都是连续的！！！
        //这个十叉树，安装数字的顺序数，是广度优先的，按照lexico则是深度优先的
        while (cur <= n){
            steps += Math.min(next - cur, n - cur+1);
            cur*=10;
            next*=10;
        }
        return steps;
    }

    public static void main(String[] args) {
        KthLexicographic kl = new KthLexicographic();
        System.out.println(kl.findKthNumber(681692778, 351251360));
    }
}
