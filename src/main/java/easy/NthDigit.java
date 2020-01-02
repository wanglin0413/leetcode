package easy;

public class NthDigit {
    public int findNthDigit(int n) {
        if(n <10)return n;
        int x = 1;
        long index = 9;
        while(true){
            if(n - x*index < 0)break;
            n-=x*index;
            x++;
            index*=10;
        }
        int numIndex = n / x;
        int inNumIndex = (x - n % x + 1)%x;
        if(inNumIndex == 0){
            inNumIndex = x;
        }

        if(inNumIndex != 1){
            numIndex++;
        }
        int num = (int)index/9 + numIndex - 1;
        for(inNumIndex--; inNumIndex >0; inNumIndex--){
            num/=10;
        }
        return num%10;
    }

    public static void main(String[] args) {
        NthDigit nd = new NthDigit();
        System.out.println(nd.findNthDigit(1000000000));
    }
}
