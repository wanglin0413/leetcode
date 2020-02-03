package hard;

import java.util.Arrays;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{newInterval};
        }
        int low = newInterval[0];
        int high = newInterval[1];
        int mergeL = 0;
        boolean mergeLeft = false;
        while (mergeL < intervals.length){
            int[] eachInterval = intervals[mergeL];
            if(eachInterval[1] >= low && eachInterval[0] <= low){
                mergeLeft = true;
                break;
            }
            if(eachInterval[0] > low){
                break;
            }
            mergeL++;
        }
        int mergeR = intervals.length-1;
        boolean mergeRight = false;
        while (mergeR >= 0){
            int[] eachInterval = intervals[mergeR];
            if(eachInterval[1] >= high && eachInterval[0] <= high){
                mergeRight = true;
                break;
            }
            if(eachInterval[1] < high){
                break;
            }
            mergeR--;
        }
        int[] afterMerge = new int[2];
        if(mergeLeft && mergeRight){
           afterMerge[0] = intervals[mergeL][0];
           afterMerge[1] = intervals[mergeR][1];
        }else if(mergeLeft){
            afterMerge[0] = intervals[mergeL][0];
            afterMerge[1] = newInterval[1];
        }else if(mergeRight){
            afterMerge[0] = newInterval[0];
            afterMerge[1] = intervals[mergeR][1];
        }else {
            afterMerge = newInterval;
        }
        int[][] result = new int[intervals.length - (mergeR - mergeL)][2];
        int index  = 0;
        for(int i = 0; i < mergeL; i++){
            result[index++] = intervals[i];
        }
        result[index++] = afterMerge;
        for(int i = mergeR+1; i < intervals.length; i++){
            result[index++] = intervals[i];
        }
        return result;
    }

    public static void main(String[] args) {
        InsertInterval ii = new InsertInterval();
        int[][] intervals = new int[][]{{1,5}};
        int[] newInterval = new int[]{0,8};
        for(int[] eachi : ii.insert(intervals, newInterval)){
            System.out.println(Arrays.toString(eachi));
        }
    }
}
