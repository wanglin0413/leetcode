package hard;

import java.util.Stack;

public class LargeRec {
    //当前位置高于栈顶，则入栈，低于，则开始出栈
    // 出栈的每个高度，都最多从其当前位置，连到当前位置的前一个（因为它前面的和当前的这个都小于它）
    //最后，每个位置都会入栈一次，出栈的时候，也会连一次，也就是每个高度，都计算了以它为高度所能连的最大面积
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int len = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int i = 0;
        while (i < len) {
            int curHeight = heights[i];
            //如果当前这个比栈顶那个大，则入栈
            if (stack.isEmpty() || curHeight >= heights[stack.peek()]){
                stack.push(i++);
            } else {
                //如果当前这个比栈顶那个小，则栈顶那个就只能到这个的前一个
                //一直pop栈顶那一个，直到当前这个比栈顶那个大
                int top = stack.pop();
                maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
            }
        }
        //把最后栈里的处理完
        while (!stack.isEmpty()){
            int top = stack.pop();
            maxArea = Math.max(maxArea, heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        LargeRec lr = new LargeRec();
        int[] heights = new int[]{3,5,4,6,2,3,1};
        System.out.println(lr.largestRectangleArea(heights));
    }
}
