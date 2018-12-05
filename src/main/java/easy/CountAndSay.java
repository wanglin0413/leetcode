package easy;

public class CountAndSay {
    public String countAndSay(int n) {
        String begin = "1";
        for(int i = 1; i < n; i++){
            begin = countAndSay(begin);
        }
        return begin;
    }

    private String countAndSay(String begin) {
        StringBuilder sb = new StringBuilder();
        char cur = begin.charAt(0);
        int count = 0;
        for(char each : begin.toCharArray()){
            if(each == cur){
                count++;
            }else {
                sb.append(count);
                sb.append(cur);
                cur=each;
                count=1;
            }
        }
        sb.append(count);
        sb.append(cur);
        return sb.toString();
    }

    public static void main(String[] args) {
        CountAndSay say = new CountAndSay();
        System.out.println(say.countAndSay(6));
    }
}
