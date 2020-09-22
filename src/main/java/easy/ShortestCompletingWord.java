package easy;

public class ShortestCompletingWord {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] wordCount = new int[26];
        for(char each : licensePlate.toCharArray()){
            if(each >= 'a' && each <= 'z'){
                wordCount[each - 'a']++;
            }else if(each >= 'A' && each <= 'Z'){
                wordCount[each - 'A']++;
            }
        }
        int minLength = 1001;
        String minWord = null;
        for(String word : words){
            if(word.length() >= minLength){
                continue;
            }
            boolean find = true;
             for(int i = 0; i < wordCount.length; i++){
                 if(wordCount[i] == 1 && word.indexOf('a' + i) < 0 ){
                     find = false;
                     break;
                 }else if(wordCount[i] > 1){
                     int j = wordCount[i];
                     int index = -1;
                     while (j > 0){
                         index = word.indexOf('a'+i, index+1);
                         j--;
                         if(index < 0){
                             find = false;
                             break;
                         }
                     }
                 }
             }
             if(find){
                 minLength = word.length();
                 minWord = word;
             }
        }

        return minWord;
    }

    public static void main(String[] args) {
        ShortestCompletingWord scw = new ShortestCompletingWord();

        String licensePlate = "1s3 PSt";
        String[] words = new String[]{"step","steps","stripe","stepple"};
        System.out.println(scw.shortestCompletingWord(licensePlate,words));
    }

}
