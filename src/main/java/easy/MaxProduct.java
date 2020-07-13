package easy;

public class MaxProduct {
    public int maximumProduct(int[] nums) {
        //前三个最大的正数
        //前两个最小的负数+最大的正数
        //三个最大的负数
        int firstPositive = -1;
        int secondPositive = -1;
        int thirdPositive = -1;

        int firstNegative = 0;
        int secondNegative = 0;

        int last1Negative = Integer.MIN_VALUE;
        int last2Negative = Integer.MIN_VALUE;
        int last3Negative = Integer.MIN_VALUE;
        for(int num : nums){
            if(num >= 0){
                if(num > firstPositive){
                    thirdPositive = secondPositive;
                    secondPositive = firstPositive;
                    firstPositive = num;
                }else if(num > secondPositive){
                    thirdPositive = secondPositive;
                    secondPositive = num;
                }else if(num > thirdPositive){
                    thirdPositive = num;
                }
            }else{
                if(num < firstNegative){
                    secondNegative =firstNegative;
                    firstNegative = num;
                }else if(num < secondNegative){
                    secondNegative = num;
                }
                if(num > last1Negative){
                    last3Negative = last2Negative;
                    last2Negative = last1Negative;
                    last1Negative = num;
                }else if(num > last2Negative){
                    last3Negative = last2Negative;
                    last2Negative = num;
                }else if(num > last3Negative){
                    last3Negative = num;
                }
            }
        }
        if(firstPositive < 0){//三个都小于0
            return last1Negative*last2Negative*last3Negative;
        }else if(secondPositive < 0){//1个大于0，两个小于0
            return firstPositive*firstNegative*secondNegative;
        }else if(thirdPositive < 0 && secondNegative < 0){//2个大于0，2个小于0
            return firstPositive*firstNegative*secondNegative;
        }else if(thirdPositive < 0 && secondNegative > 0){//2个大于0，1个小于0
            return firstPositive*secondPositive*firstNegative;
        }else {
            return Math.max(firstPositive*secondPositive*thirdPositive, firstPositive*firstNegative*secondNegative);
        }

    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        int[] nums = new int[]{-1, -2, -3};
        System.out.println(maxProduct.maximumProduct(nums));
    }
}
