package unclissified;

import java.util.Arrays;

public class MergeSort {

    public int mergeSort(int[] array){
        return mergeSort(array, 0, array.length);
    }

    private int mergeSort(int[] array, int start, int end) {
        if(start == end - 1)return 0;
        int mid = (start + end) /2;
        int half1 = mergeSort(array, start, mid);
        int half2 = mergeSort(array, mid, end);
        int half3 = merge(array, start, mid, end);
        return half1 + half2 + half3;
    }

    private int merge(int[] array, int start, int mid, int end) {
        int[] firstHalf = Arrays.copyOfRange(array, start, mid);
        int count = 0;
        int firstIdx = 0;
        int secondIdx = mid;
        int arrayIdx = start;
        for(; firstIdx < mid-start || secondIdx < end; ){
            if(firstIdx < mid-start && (secondIdx >= end || firstHalf[firstIdx] < array[secondIdx])) array[arrayIdx++] = firstHalf[firstIdx++];
            if(secondIdx < end && (firstIdx >= mid - start || firstHalf[firstIdx] >= array[secondIdx])) {
                array[arrayIdx++] = array[secondIdx++];
                count += mid-start - firstIdx;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] array = new int[]{1,2,3,7,5,6,4,0};
        System.out.println(ms.mergeSort(array));
        System.out.println(Arrays.toString(array));
    }
}
