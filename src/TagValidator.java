import java.util.Stack;

/**
 * Created by wanglin03 on 2017/10/9.
 */
public class TagValidator {
    public boolean isValid(String code) {
        if(!code.startsWith("<"))return false;
        if(code.startsWith("<![CDATA["))return false;
        Stack<String> tagStack = new Stack<>();
        for(int i = 0; i<code.length(); i++){
            if(code.substring(i).startsWith("<![CDATA[")){
                i+=9;
                while (!code.substring(i).startsWith("]]>")){
                    i++;
                    if(i >= code.length())return false;
                }
                i+=2;
                if(i == code.length() -1)return false;
                continue;
            }

            if(code.substring(i).startsWith("</")){
                i+=2;
                String tag = "";
                while (true){
                    if(i >= code.length())return false;
                    if(code.charAt(i) == '>')break;
                    tag += code.charAt(i);
                    i++;
                }
                if(tagStack.isEmpty() || !tagStack.pop().equals(tag))return false;
                if(i != code.length()-1 && tagStack.isEmpty()) return false;
            }
            if(code.substring(i).startsWith("<")){
                i++;
                String tag = "";
                while (true){
                    if(i >= code.length())return false;
                    if(code.charAt(i) == '>') break;
                    if(!Character.isUpperCase(code.charAt(i)))return false;
                    tag += code.charAt(i);
                    i++;
                }
                if(tag.length() == 0 || tag.length() > 9)return false;
                tagStack.push(tag);
            }
        }
        if(!tagStack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args){
        TagValidator validator = new TagValidator();
        boolean valid = validator.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>");
        System.out.print(valid);
    }

}
