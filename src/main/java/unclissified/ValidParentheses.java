package unclissified;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if(s == null || s.isEmpty())return true;
        Stack<Character> stack = new Stack<>();
        for(char each :s.toCharArray()){
           if(each =='(' || each =='{' || each =='['){
               stack.push(each);

           }else {
               if(stack.isEmpty())return false;
               char temp = stack.pop();
               switch (temp){
                   case '(':
                       if(each != ')'){
                           return false;
                       }
                       break;
                   case '[':
                       if(each != ']'){
                           return false;
                       }
                       break;
                   case '{':
                       if(each != '}') return false;
                       break;
                       default:
                           break;
               }
           }
        }
        return stack.isEmpty();
    }

}
