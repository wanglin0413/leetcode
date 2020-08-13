package easy;


import java.util.Stack;

public class BaseBallGame {
    public int calPoints(String[] ops) {
        int score = 0;
        Stack<Integer> stack = new Stack<>();
        int cur;
        for(String each : ops){
            if(each.charAt(0) == 'C' && !stack.isEmpty()){
               stack.pop();
            } else if(each.charAt(0) == '-' || Character.isDigit(each.charAt(0))){
                cur = Integer.parseInt(each);
                stack.push(cur);
            }else if(each.charAt(0) == '+'){
                int last1 = stack.pop();
                int last2 = stack.peek();
                stack.push(last1);
                stack.push(last1 + last2);
            }else if(each.charAt(0) == 'D'){
                stack.push(stack.peek() * 2);
            }
        }
        while (!stack.isEmpty()){
            score += stack.pop();
        }
        return score;
    }

    public static void main(String[] args) {
        BaseBallGame bbg = new BaseBallGame();
        String[] ops = new String[]{"5","2","C","D","+"};
        System.out.println(bbg.calPoints(ops));
    }
}
