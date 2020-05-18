package easy;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int A = 0;
        int[] dcount = new int[10];
        int[] guessCount = new int[10];
        for(int i = 0; i < secret.length(); i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g){
                A++;
            }else {
                dcount[s - '0'] +=1;
                guessCount[g - '0'] +=1;
            }
        }
        int B= 0;
        for(int i = 0; i < dcount.length; i++){
            B+= Math.min(dcount[i], guessCount[i]);
        }
        return  A + "A" + B + "B";
    }

    public static void main(String[] args) {
        BullsAndCows bc = new BullsAndCows();
        System.out.println(bc.getHint("1123", "0111"));
    }
}
