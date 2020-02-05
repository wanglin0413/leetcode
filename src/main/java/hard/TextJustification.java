package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int[] count = new int[words.length];
        for(int i = 0; i < words.length; i++){
            count[i] = words[i].length();
        }
        List<String> result = new ArrayList<>();
        int rowCount = 0;
        int rowStart = 0;
        int rowLength = 0;
        while (rowStart + rowCount < words.length){
            //再加一个词超了
            if(rowLength + count[rowStart + rowCount] > maxWidth){
                result.add(generate(words, count, rowStart, rowCount, maxWidth));
                rowStart += rowCount;
                rowCount = 0;
                rowLength = 0;
            }else {//没超，继续加
                rowLength += count[rowStart + rowCount] + 1;
                rowCount++;
            }
        }
        if(rowCount != 0){
            //加上最后一行
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < rowCount-1; i++){
                sb.append(words[rowStart+ i]);
                sb.append(" ");
            }
            sb.append(words[rowStart + rowCount - 1]);
            char[] spaces = new char[maxWidth - sb.length()];
            Arrays.fill(spaces, ' ');
            sb.append(spaces);
            result.add(sb.toString());
        }
        return result;
    }
    //wordStart开始，wordCount
    private String generate(String[] words, int[] count, int wordStart, int wordCount, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        int wordLength = 0;
        for(int i = 0; i < wordCount; i++){
            wordLength += count[wordStart + i];
        }
        int space = maxWidth - wordLength;
        //每个单词后面的空格数
        if(wordCount == 1){
            sb.append(words[wordStart]);
            char[] spaces = new char[space];
            Arrays.fill(spaces, ' ');
            sb.append(spaces);
            return sb.toString();
        }
        int each = space/(wordCount-1);
        //余数
        int remainedSpace = space - each * (wordCount - 1);
        char[] spaces = new char[each+1];
        Arrays.fill(spaces, ' ');
        //前余数个，每个词后面加each+1个空格
        for(int i = 0; i < remainedSpace; i++){
          sb.append(words[wordStart+i]);
          sb.append(spaces);
        }
        //后面的，每个词后面加each个空格
        for(int i = remainedSpace; i < wordCount - 1; i++){
            sb.append(words[wordStart+ i]);
            sb.append(spaces, 0, spaces.length - 1);
        }
        sb.append(words[wordStart + wordCount - 1]);
        return sb.toString();
    }

    public static void main(String[] args) {

        TextJustification tj = new TextJustification();
        String[] words = new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
        System.out.println(tj.fullJustify(words, 16));
    }

}
