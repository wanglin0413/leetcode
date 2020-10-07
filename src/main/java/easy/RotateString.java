package easy;

public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        if(A.length() == 0)return true;
        int length = A.length();
        int bIdxStart = -1;
        int aIdx;
        while (true) {
            bIdxStart = B.indexOf(A.charAt(0), bIdxStart+1);
            aIdx = 0;
            int bIdx = bIdxStart;
            if (bIdx < 0) return false;
            while (aIdx < length) {
                if (A.charAt(aIdx) != B.charAt(bIdx % (length))) break;
                aIdx++;
                bIdx++;
            }
            if(aIdx == length)return true;
        }
    }

    public static void main(String[] args) {
        RotateString rs = new RotateString();
        String A = "bbbacddceeb";
        String B = "ceebbbbacdd";
        System.out.println(rs.rotateString(A, B));
    }
}
