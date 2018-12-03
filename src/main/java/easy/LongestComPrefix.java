package easy;

public class LongestComPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)return "";
        StringBuilder sb = new StringBuilder();
        int index = 0;
        char tmp = 0;
        while (index < strs[0].length()){
            boolean end=false;
            tmp = strs[0].charAt(index);
            for(int i = 1; i < strs.length; i++){
                if(index == strs[i].length() || strs[i].charAt(index) != tmp){
                    end=true;
                    break;
                }
            }
            if(end)break;
            sb.append(tmp);
            index++;
        }
        return sb.toString();
    }
}
