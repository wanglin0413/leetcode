package medium;


import java.util.Arrays;

public class ReOrderedPowerTwo {
    public boolean reorderedPowerOf2(int N) {
        if(N == 0)return false;
        if(N==1)return true;
        char[] nums = String.valueOf(N).toCharArray();
        int length = nums.length;
        int[] count = toArray(nums);
        int baseNum = 1;
        for(int power = 1; power < 32; power++){
            baseNum <<= 1;
            System.out.println(baseNum);
            char[] powerNum = String.valueOf(baseNum).toCharArray();
            if(powerNum.length == length){
                int[] countNum = toArray(powerNum);
                if(Arrays.equals(count, countNum)){
                    return true;
                }
            }
        }
        return false;
    }

    private int[] toArray(char[] nums) {
        int[] result = new int[10];
        Arrays.fill(result, 0);
        for (char each : nums) {
            result[each - 48]++;
        }
        return result;
    }


    public static void main(String[] args) {
        ReOrderedPowerTwo rpt = new ReOrderedPowerTwo();
        System.out.println(rpt.reorderedPowerOf2(1042));
    }
}
