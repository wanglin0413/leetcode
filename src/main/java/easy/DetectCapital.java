package easy;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        //所有都是大写
        //只有首字母大写
        //所有都是小写
        if(word.length() <= 1)return true;
        boolean first = Character.isUpperCase(word.charAt(0));
        if(!first){
            for(int i = 1; i < word.length(); i++){
                if(Character.isUpperCase(word.charAt(i)))return false;
            }
            return true;
        }
        boolean second = Character.isUpperCase(word.charAt(1));
        for(int i = 2; i < word.length(); i++){
            if(Character.isUpperCase(word.charAt(i)) != second)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        DetectCapital dc = new DetectCapital();
        System.out.println(dc.detectCapitalUse("Ml"));
    }
}
