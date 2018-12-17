package easy;

import java.util.Arrays;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length -1;
        while (left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target)return new int[]{left +1, right +1};
            if(sum > target){
                right = binarySearch(target - numbers[left], left, right -1, numbers, true);
            }else {
                left = binarySearch(target - numbers[right], left +1, right, numbers, false);
            }
        }
        return null;
    }
    //如果从左缩进查找，则返回大于等于target的第一个
    //如果从右缩进查找，则返回小于等于target的第一个
    private int binarySearch(int num, int begin, int end, int[] numbers, boolean fromRight) {
        if(begin+1 == end){
            if(fromRight)return end;
            return begin;
        }
        int mid = begin + end >> 1;
        if(numbers[mid] == num){
            return mid;
        }else if(numbers[mid] < num){
            return binarySearch(num, mid, end, numbers, fromRight);
        }else {
            return binarySearch(num, begin, mid, numbers, fromRight);
        }
    }

    public static void main(String[] args) {
        TwoSumII ts2 = new TwoSumII();
        int[] testcase = new int[]{2,8,13,14,17};
        System.out.println(Arrays.toString(ts2.twoSum(testcase, 31)));
    }
}
