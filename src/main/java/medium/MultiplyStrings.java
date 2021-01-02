package medium;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        List<Integer> result = new ArrayList<>();
        for(int i =0; i < num1.length() + num2.length(); i++){
            result.add(i, 0);
        }
        //弄一个位置的索引
        for(int i  = 0; i < num1.length(); i++){
            for(int j = 0; j < num2.length(); j++){
                int oneResult = (num1.charAt(i)-'0') * (num2.charAt(j) - '0');
                result.set(i+j + 1, result.get(i+j+1) + oneResult);
            }
        }
        processJinWei(result, result.size() - 1);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (result.get(i) == 0)i++;
        for(int idx = i; idx < result.size(); idx++){
            sb.append(result.get(idx));
        }
        return sb.length() == 0 ? "0" :sb.toString();
    }

    private void processJinWei(List<Integer> result, int idx) {
        while (idx >= 1){
            if(result.get(idx) >= 10){
                int jinwei  = result.get(idx) / 10;
                result.set(idx, result.get(idx) % 10);
                result.set(idx - 1, result.get(idx - 1) + jinwei);
            }
            idx--;
        }
    }

    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println(ms.multiply("123456789", "987654321"));
    }
}
