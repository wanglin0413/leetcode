package easy;

import java.util.ArrayList;
import java.util.List;

public class LargeGroup {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        char cur = ' ';
        int start = -1;
        int end = -1;
        for(char each : s.toCharArray()){
            end++;
            if(each != cur){
                if(end - start >= 3){
                    List<Integer> one = new ArrayList<>();
                    one.add(start);
                    one.add(end -1);
                    result.add(one);
                }
                start = end;
                cur = each;
            }
        }
        if(end - start >= 3){
            List<Integer> one = new ArrayList<>();
            one.add(start);
            one.add(end);
            result.add(one);
        }
        return result;
    }

    public static void main(String[] args) {
        LargeGroup lg = new LargeGroup();
        String s = "abbxxxxzyy";
        System.out.println(lg.largeGroupPositions(s));
    }
}
