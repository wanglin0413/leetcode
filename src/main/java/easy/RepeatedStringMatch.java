package easy;

public class RepeatedStringMatch {
    public int repeatedStringMatch(String A, String B) {
        int count = 1;
        StringBuilder sb = new StringBuilder(A);
        int times = (B.length() / A.length()) + 1;
        while (times-- >= 0){
            if(sb.indexOf(B) != -1)return count;
            sb.append(A);
            count++;
        }
        return -1;
    }
}
