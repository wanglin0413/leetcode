package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortestDis {
    public int[] shortestToChar(String S, char C) {
        List<Integer> idx = new ArrayList<>();
        int[] result = new int[S.length()];
        for(int i  = 0; i < S.length(); i ++){
            if(S.charAt(i) == C)idx.add(i);
        }
        int last = -10001;
        int begin = 0;
        int cur = idx.get(begin++);
        for(int i = 0; i < S.length(); i++){
          if(i > cur){
              last = cur;
              if(begin == idx.size()){
                  cur = 10001;
              }else {
                  cur = idx.get(begin++);

              }
          }
          result[i] = Math.min(i - last, cur - i);
        }
        return result;
    }

    public static void main(String[] args) {
        ShortestDis sd = new ShortestDis();
        String S = "aaba";
        char C = 'b';

        System.out.println(Arrays.toString(sd.shortestToChar(S, C)));
    }
}
