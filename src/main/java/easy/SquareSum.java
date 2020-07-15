package easy;

public class SquareSum {
    public boolean judgeSquareSum(int c) {
        for(int i = 0; i*i<=c/2; i++){
            if(isSquare(c - i*i)){
                return true;
            }
        }
        return false;
    }

    private boolean isSquare(int i) {
        if(i == 0 || i == 1)return true;
        long sqrtI = 1;
        while (true){
            long j = sqrtI*sqrtI;
            if(j== i)return true;
            if(j < i && (sqrtI+1)*(sqrtI+1) > i){
                return false;
            }
            if(j>i && (sqrtI-1)*(sqrtI-1) <i){
                return false;
            }
            sqrtI = sqrtI - Math.floorDiv(sqrtI*sqrtI - i,2*sqrtI) - 1;
        }
    }

    public static void main(String[] args) {
        SquareSum ss = new SquareSum();
        System.out.println(ss.judgeSquareSum(1000000));
    }
}
