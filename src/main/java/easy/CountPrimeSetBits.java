package easy;

public class CountPrimeSetBits {
    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        int n = L, nbits = 0;
        while (n > 0) {
            n = n & (n - 1);
            nbits++;
        }
        if(isPrime(nbits))result++;
        for(int i = L + 1; i <= R; i++){
            n = i;
            nbits++;
            while (0 == (n & 1)) {
                nbits--;
                n >>>= 1;
            }
            if(isPrime(nbits)){
                result++;
            }
        }
        return result;
    }

    private boolean isPrime(int ones) {
        int[] primes = new int[]{0,0,1,1,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0};
        return primes[ones] == 1;
    }

    private int countOnes(int num) {
        int count = 0;
        while (num != 0){
            count += num % 2;
            num /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        CountPrimeSetBits countPrimeSetBits = new CountPrimeSetBits();
        System.out.println(countPrimeSetBits.countPrimeSetBits(567,607));
    }
}
