package easy;

import java.util.Arrays;

public class ArrayIntersections {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m = nums1.length;
        int n = nums2.length;
        int i=0;
        int j=0;
        int cur=0;
        while(i <m && j < n){
            if(nums1[i] == nums2[j]){
                if(cur ==0 || nums1[cur-1] != nums1[i]){
                    nums1[cur++]=nums1[i];
                }
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        return Arrays.copyOf(nums1, cur);
    }
}
