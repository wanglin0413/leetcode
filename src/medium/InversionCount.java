package medium;

public class InversionCount {
    public boolean isIdealPermutation(int[] A) {
        if(A[0] > 1) return false;
        for(int i = 1; i < A.length; i++){
            if(A[i] < A[i-1] ){
                if(A[i-1] - A[i] > 1 || A[i] - i > 1 || i - A[i] > 1)
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        InversionCount ic = new InversionCount();
        int[] test = new int[]{0,3,1,2};
        System.out.println(ic.isIdealPermutation(test));
    }
}
