package easy;

import java.util.HashMap;
import java.util.Map;

public class Boomerange {
    public int numberOfBoomerangs(int[][] points) {
        if(points.length <= 3)return 0;
        Map<Integer, Integer> count = new HashMap<>();
        for(int i =0; i < points.length; i++){
            for(int j = i+1; j < points.length; j++){
                int dis = (points[j][0] - points[i][0])*(points[j][0] - points[i][0])+(points[j][1] - points[i][1])*(points[j][1] - points[i][1]);
                count.merge(dis, 1,(a,b)->a+b);
            }
        }
        int result = 0;
        for(int each : count.values()){
            result += each*(each-1);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
