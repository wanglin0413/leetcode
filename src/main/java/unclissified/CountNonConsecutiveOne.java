package unclissified;

public class CountNonConsecutiveOne {


    public int findIntegers(int num) {
        int bitNum = Integer.toBinaryString(num).length();
        if(bitNum == 1)return 2;
        if(bitNum == 2)return 3;
        System.out.println("bit count: " + bitNum);
        int count = getCount(bitNum-1);
        System.out.println("part1:" + count);
        if(num - (1 << bitNum-1) == 0)return count+1;
        int bitNum2 = Integer.toBinaryString(num - (1 << bitNum-1)).length();
        System.out.println(bitNum2);
        int count1 = getCount(bitNum2);

        return count+count1;
    }

    private int getCount(int bitNum) {
        if(bitNum == 1) return 2;
        if(bitNum == 2) return 3;
        int result = 0;
        return result+getCount(bitNum - 2)+getCount(bitNum-1);
    }

    public static void main(String[] args) {
        CountNonConsecutiveOne count = new CountNonConsecutiveOne();
        System.out.println("result: " + count.findIntegers(6));
    }
}
