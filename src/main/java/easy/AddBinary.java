package easy;

import java.util.Arrays;

public class AddBinary {
    public String addBinary(String a, String b) {
        int aI = a.length() -1;
        int bI = b.length() -1;
        int[] sum = new int[aI > bI?aI +2:bI+2];
        Arrays.fill(sum, 0);
        int sI = sum.length -1;
        boolean carry = false;
        while (sI >=0){
            if(carry){
                sum[sI]++;
                carry=false;
            }
            if(aI >= 0){
                char ac = a.charAt(aI--);
                sum[sI] +=  (ac- 48);
            }
            if(bI >=0){
                char bc = b.charAt(bI--);
                sum[sI] +=  (bc- 48);
            }
           if(sum[sI] > 1){
               carry = true;
               sum[sI] -=2;
           }
           sI--;
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        if(sum[0] == 0){
            index++;
        }
        while (index < sum.length){
            sb.append(sum[index++]);
        }
       return sb.toString();
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary("1", "1111"));
    }
}
