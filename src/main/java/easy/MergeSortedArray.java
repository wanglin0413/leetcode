package easy;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] pre = new int[m];
        for(int i =0; i < m; i++){
            pre[i] = nums1[i];
        }
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < m || j < n){
            if(i < m && j < n){
                nums1[index++] = pre[i] < nums2[j]?pre[i++]:nums2[j++];
            }else if(i < m){
                nums1[index++] = pre[i++];
            }else {
                nums1[index++] = nums2[j++];
            }
        }
    }
}
