package unclissified;

public class EqualArray {
    public int minMoves(int[] nums) {
        //1. 结果必须是length的倍数
        //2. 现在的length*each - sum = （length-1）*return
        //3. each = return + min -> return = sum - min*n
        //注意边界检查
        int length = nums.length;
        if(length == 1)return 0;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for(int each:nums){
            sum+=each;
            if(each < min){
                min = each;
            }
        }
        return (int)(sum - min*length);
    }

    public static void main(String[] args) {
        EqualArray ea = new EqualArray();
        int[] array = new int[]{-100,0,100};
//        ea.minMoves(array);
        System.out.println(ea.minMoves(array));
    }
}
