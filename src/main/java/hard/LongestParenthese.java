package hard;

import java.util.Stack;

public class LongestParenthese {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
    //括号是否有效的两个条件：
    //1. 左右括号数量相等；
    // 2. 从左往右的话，右括号数不能大于左括号数；从右往左，左括号不能大于右括号；
    //从左边开始，两种情况：
        // 1. 右括号数大于左括号数，重新计数；
        //2. 左括号数大于右括号数，从右往左数；

    public int longestValidParentheses1(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        LongestParenthese lp = new LongestParenthese();
        System.out.println(lp.longestValidParentheses1("(()()(()"));
    }
}
