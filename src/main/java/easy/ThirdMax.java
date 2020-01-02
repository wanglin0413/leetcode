package easy;

public class ThirdMax {

    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long min = Long.MIN_VALUE;
        for(int each : nums){
            if(each > max){
                min = second;
                second =max;
                max = each;
            }else if(each > second){
                min = second;
                second = each;
            }else if(each > min){
                min = each;
            }
        }
        return (min == Long.MIN_VALUE) ? (int) max : (int) min;
    }
}
