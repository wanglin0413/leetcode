package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if(numRows == 0)return result;
        List<Integer> list = new ArrayList<>();
        result.add(list);
        list.add(1);
        for(int i = 1; i < numRows; i++){
            List<Integer> curlist = new ArrayList<>(i+1);
            curlist.add(1);
            for(int j = 1; j < i; j++){
                curlist.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            curlist.add(1);
            result.add(curlist);
        }
        return result;
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        List<List<Integer>> result = pt.generate(1);
        for(List<Integer> each : result){
            System.out.println(Arrays.toString(each.toArray()));
        }
    }
}
