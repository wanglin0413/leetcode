/**
 * Created by wanglin03 on 2017/9/25.
 */
public class QuickSelection {
    public int findKthLargest(int[] nums, int k){
        int index = quick_select(nums, 0, nums.length - 1, k);
        return nums[index];
    }

    private int quick_select(int[] nums, int low, int high, int k) {
        int index = partation(nums,low, high);
        if(index < nums.length - k){
            return quick_select(nums,index+ 1, high, k);
        }
        else if(index == nums.length - k){
            return index;
        }else
            return quick_select(nums, low, index,k);
    }

    private int partation(int[] nums, int low, int high) {
        if(low == high){
            return low;
        }
        int i = low;
        int j = high;
        int pivot = nums[low];
        while (true){
            while(nums[i] <= pivot){
                i++;
                if(i == high){
                    break;
                }
            }
            while ((nums[j] >= pivot)){
                j--;
                if(j == low){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            swap(nums, i, j);
        }
        //todo 为什么和j交换，为什么返回j？
        swap(nums, low, j);
        return j;
    }

    private void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    public static void main(String[] args){
        QuickSelection solution = new QuickSelection();
        int[] ints = new int[]{1,1};
        int answer = solution.findKthLargest(ints, 1);
        System.out.print(answer);
    }
}
