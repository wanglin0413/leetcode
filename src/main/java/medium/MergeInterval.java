package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MergeInterval {
	public int[][] merge(int[][] intervals) {
		Set<Integer> starts = new HashSet<>();
		for(int i = 0; i < intervals.length; i++){
			starts.add(intervals[i][0]);
		}
		Object[] startsArray = starts.toArray();
		Arrays.sort(startsArray);

		Map<Integer, List<int[]>> intervalMap = new HashMap<>();
		for(int[] interval : intervals){
			intervalMap.putIfAbsent(interval[0], new ArrayList<>());
			intervalMap.get(interval[0]).add(interval);
		}
		List<int[]> result = new ArrayList<>();
		for(Object start : startsArray){
			int intvalue = (int) start;
			List<int[]> intervalWithSameStart = intervalMap.get(intvalue);
			int[] oneInterval = new int[2];
			oneInterval[0] = intvalue;
			oneInterval[1] = intvalue;
			for(int[] each : intervalWithSameStart){
				if(each[1] > oneInterval[1]){
					oneInterval[1] = each[1];
				}
			}
			if(!result.isEmpty()){
				int[] last = result.get(result.size() - 1);
				if(oneInterval[0] > last[1]){
					result.add(oneInterval);
				}else {
					last[1] = Math.max(oneInterval[1], last[1]);
				}
			}else {
				result.add(oneInterval);
			}
		}
		int[][] arrayResult = new int[result.size()][2];
		for(int i =0; i < result.size(); i++){
			arrayResult[i] = result.get(i);
		}
		return arrayResult;
	}

}
