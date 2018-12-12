package easy;

import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        Integer[] result = new Integer[rowIndex+1];
        result[0] = 1;
        result[rowIndex] =1;
        boolean incr = true;
        for (int i = 2; i <= rowIndex; i++) {
            int n = (i+1) >> 1;
            if (incr) {
                for (int j = 1; j < n; j++) {
                    result[rowIndex - j] = result[j - 1] + result[j];
                }
                result[rowIndex - n] = 2*result[n-1];
            } else {
                for(int j = rowIndex - 1; j > rowIndex-n; j--){
                    result[rowIndex - j]= result[j+1]+result[j];
                }
            }
            incr = !incr;
        }
        if(incr){
            for(int i = 1; i < (rowIndex>>1)+1; i++){
                result[rowIndex -i] = result[i];
            }
        }else {
            for(int i = 1; i <(rowIndex >>1)+1; i++){
                result[i]=result[rowIndex-i];
            }
        }
        return Arrays.asList(result);
    }

    public static void main(String[] args) {
        PascalTriangleII ptII = new PascalTriangleII();
        List<Integer> result = ptII.getRow(6);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
