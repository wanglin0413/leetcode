package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinIndexSum {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int min = Integer.MAX_VALUE;
        List<String> rawResult = new ArrayList<>();
        Map<String, Integer> list1Map = new HashMap<>();
        for(int i = 0; i < list1.length; i++){
            list1Map.put(list1[i], i);
        }
        for (int i =0; i < list2.length; i++){
            if(list1Map.get(list2[i]) != null){
                int indexSum = i + list1Map.get(list2[i]);
                if(indexSum < min){
                    min = indexSum;
                    rawResult.clear();
                    rawResult.add(list2[i]);
                }else if(indexSum == min){
                    rawResult.add(list2[i]);
                }
            }
        }
        String[] result = new String[rawResult.size()];
        return rawResult.toArray(result);
    }
}
