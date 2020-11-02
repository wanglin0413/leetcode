package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackPermutation {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        if (nums.length == 0) return result;
        addOnePermute(new ArrayList<>(), nums, 0, stack);
        return result;
    }

    private void addOnePermute(List<Integer> oneResult, int[] nums, int start, Stack<Integer> stack) {
        //如果序列遍历完
        if (start == nums.length) {
            while (!stack.isEmpty()) {
                oneResult.add(stack.pop());
            }
            result.add(oneResult);
            return;
        }

        //没遍历完，栈为空
        if (stack.isEmpty()) {
            stack.push(nums[start]);
            addOnePermute(oneResult, nums, start + 1, stack);
        } else {//栈不为空
            //弹栈
            List<Integer> oneResult1 = new ArrayList<>(oneResult);
            Stack<Integer> stack1 = (Stack<Integer>) stack.clone();
            oneResult1.add(stack1.pop());

            stack1.push(nums[start]);
            addOnePermute(oneResult1, nums, start + 1, stack1);
            //不弹栈
            stack.push(nums[start]);
            addOnePermute(oneResult, nums, start + 1, stack);
        }
    }

    public static void main(String[] args) {
        StackPermutation stackPermutation = new StackPermutation();
        int[] nums = new int[]{1,2,3};
        System.out.println(stackPermutation.permute(nums));
    }
}
