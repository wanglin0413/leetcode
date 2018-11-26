package medium;

public class GasStation {
    //只要gas总和大于等于cost总和，一定能够走遍--如何证明？
    //找到diff的sum的最小值处，result=min+1
    //不论从哪个开始遍历，min的位置都是一样的
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i = 0; i < gas.length ; i++){
            int diff = gas[i] - cost[i];
            sum += diff;
            if(sum < min) {
                min = sum;
                minIndex = i;
            }
        }
        if(sum < 0)return -1;
        return (minIndex+1) % gas.length;
//        int gasSum = 0;
//        for(int each:gas){
//            gasSum+=each;
//        }
//        int costSum=0;
//        for(int each:cost){
//            costSum+=each;
//        }
//        if(gasSum < costSum)return -1;
//        int begin = 0;
//        int currentIndex = 0;
//        int currentGas = 0;
//        int currentCost = 0;
//        int traveled = 0;
//        while (true){
//            currentCost+=cost[currentIndex % gas.length];
//            currentGas+=gas[currentIndex % gas.length];
//            if(currentCost > currentGas){
//                begin++;
//                currentIndex = begin;
//                currentCost = 0;
//                currentGas =0;
//                traveled = 0;
//            }else {
//                traveled++;
//                currentIndex++;
//            }
//            if(begin == gas.length)return -1;
//            if(traveled == gas.length)return begin;
//        }
    }
}
