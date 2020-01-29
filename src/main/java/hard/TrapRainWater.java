package hard;

public class TrapRainWater {
    public int trap1(int[] height) {
        if(height.length < 3)return 0;
        int result = 0;
        int leftMax = height[0];
        int[] rightMax = new int[height.length];
        for(int i = height.length - 2; i > 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }
        for(int i = 1; i < height.length-1; i++){
            leftMax = Math.max(leftMax, height[i-1]);
            int tmp = Math.min(leftMax, rightMax[i]) - height[i];
            if(tmp > 0)result+=tmp;
        }
        return result;
    }
    public int trap(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length -1;
        while (left < right){
            if(height[left] < height[right]){
                int tmp = height[left];
                while (left < right && height[++left] < tmp){
                    result+= tmp - height[left];
                }
            }else {
                int tmp = height[right];
                while (left < right && height[--right] < tmp){
                    result+= tmp - height[right] ;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TrapRainWater trw = new TrapRainWater();
        int[] nums = new  int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trw.trap(nums));
    }
}
