package easy;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        //利用了多数元素 大于 n/2个的条件
        int major = nums[0];
        int count = 1;
        int n = nums.length;
        for(int i = 1; i < n ; i++){
            if(count == 0){
                major = nums[i];
                count++;
            }else if(nums[i] == major){
                count++;
            }else {
                count--;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] testcase = new int[]{2,2,1,1,1};
        System.out.println(me.majorityElement(testcase));
    }
}
