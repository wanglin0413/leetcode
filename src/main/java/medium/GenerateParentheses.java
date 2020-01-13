package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, n, n, "");

        return result;
    }
    //如果栈为空，则只能push
    //如果栈不为空，则可以push，也可以pop
    //如果 i = n-1，则只能pop
    //如果i = n-1，且栈为空，则括号构建完毕
    private void generateParenthesis(List<String> result, int left, int right, String s) {
        if(left == 0 && right == 0){
            result.add(s);
            return;
        }
        if(left > 0){
            generateParenthesis(result, left -1, right, s+"(");
        }

        if(right > left){
            generateParenthesis(result, left, right - 1, s+ ")");
        }
    }




    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }
}
