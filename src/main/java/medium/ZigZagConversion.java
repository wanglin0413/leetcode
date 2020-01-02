package medium;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1)return s;
        StringBuilder sb = new StringBuilder();
        int span = numRows + numRows - 2;
        for(int i = 0; i < numRows; i++){
            int j = 0;
            if(i == 0 || i == numRows - 1){
                while (i+j < s.length()){
                    sb.append(s.charAt(i+j));
                    j += span;
                }
            }else {
                while (i+j < s.length()){
                    sb.append(s.charAt(i+j));
                    if(j + span - i < s.length()){
                        sb.append(s.charAt(j + span - i));
                    }
                    j += span;
                }
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        ZigZagConversion zzc = new ZigZagConversion();
        System.out.println(zzc.convert("AB",1));
    }
}
