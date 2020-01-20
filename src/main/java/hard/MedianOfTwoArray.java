package hard;

public class MedianOfTwoArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0)
            return nums2.length % 2 == 0? (nums2[nums2.length/2 - 1] + nums2[nums2.length/2])/2.0 :
                    nums2[nums2.length/2];
        if(nums2.length == 0)
            return nums1.length % 2 == 0? (nums1[nums1.length/2 - 1] + nums1[nums1.length/2])/2.0 :
                    nums1[nums1.length/2];
        int mid = (nums1.length + nums2.length) / 2;
        boolean two = (nums1.length + nums2.length) % 2 == 0;
        if(two) mid = mid - 1;
        int i = 0, j = 0, count = 0;
        while (i < nums1.length|| j < nums2.length){
            if(count == mid)break;
            if(i < nums1.length && (j >= nums2.length|| nums1[i] < nums2[j])){
                i++;
            }else {
                j++;
            }
            count++;
        }
        double result = 0;
        if (j < nums2.length && (i == nums1.length || nums1[i] > nums2[j])) {
            result += nums2[j++];
        } else {
            result += nums1[i++];
        }
        if(two){
            if (j < nums2.length && (i == nums1.length || nums1[i] > nums2[j])) {
                result += nums2[j];
            } else {
                result += nums1[i];
            }
            result /= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        MedianOfTwoArray mta = new MedianOfTwoArray();
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{2};
        System.out.println(mta.findMedianSortedArrays(nums1, nums2));
    }
}
