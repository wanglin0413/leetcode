package unclissified;

import java.util.Arrays;

public class Sort {
    public static int[] mergeSort(int[] array){
        int length = array.length;
        mergeSort(array, 0, length);
        return array;
    }

    private static void mergeSort(int[] array, int low, int high) {
        if(low >= high - 1)return;
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] firstHalf = Arrays.copyOfRange(array, low, mid);
        int firstIdx = 0;
        int secondIdx = mid;
        int idx = low;
        while (idx < high){
            if(secondIdx < high && (firstIdx >= mid -low || firstHalf[firstIdx] > array[secondIdx])){
                array[idx++] = array[secondIdx++];
            }
            if(firstIdx < mid - low && ( secondIdx >= high || firstHalf[firstIdx] <= array[secondIdx])){
                array[idx++] = firstHalf[firstIdx++];
            }
        }
    }


    public static int[] quickSort(int[] array){
        quickSort(array, 0, array.length);
        return array;
    }

    private static void quickSort(int[] array, int low, int high) {
        if(low >= high - 1) return;
        int index =partition(array, low, high - 1);
        quickSort(array, low, index);
        quickSort(array, index + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        if(low == high)return low;

        int pivot = array[low];
        while (low < high){
            while (low < high){
                if(pivot < array[high]){
                    high--;
                }else {
                    array[low++] = array[high];
                    break;
                }
            }
            while (low < high){
                if(array[low] < pivot) {
                    low++;
                }else {
                    array[high--] = array[low];
                    break;
                }
            }
        }
        array[low] = pivot;
        return low;
    }

    public static int[] heapSort(int[] array){
        //建堆
        heapify(array);
        //循环delMax，放到最后
        for(int j = array.length -1 ; j > 0; j--){
            swap(array, 0, j);
            sink(array, 0, j-1, 0);
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {

    }

    private static void heapify(int[] array) {
        for(int j = array.length / 2 - 1; j >= 0; j--){
            sink(array, 0, array.length, j);
        }
    }

    private static void sink(int[] array, int low, int high, int j) {

    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,0};
//        System.out.println(Arrays.toString(Sort.mergeSort(array)));
        System.out.println(Arrays.toString(Sort.quickSort(array)));
    }
}
