import java.util.*;
import java.util.HashSet;

/**
 * Created by wanglin03 on 2017/9/29.
 */
public class Candies {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for(int i:candies){
            set.add(i);
        }
        return Math.min(candies.length/2, set.size());
    }
}
