package easy;

public class RepeatedSubString {
    public boolean repeatedSubstringPattern(String s) {
        int m = s.length();
        if(m == 1)return false;
        int[] primes = generatePrimes(m/2+1);
        primes[primes.length - 1] = m;
        for(int each:primes){
            if(m % each == 0){
                int subIndex = m / each;
                boolean result = true;
                for(int i=0; i < each-1; i++){
                    if(!s.substring(0,subIndex).equals(s.substring(subIndex+subIndex*i, subIndex+subIndex*(i+1)))){
                        result = false;
                    }
                }
                if(result) return result;
            }
        }
        return false;
    }

    int[] generatePrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for(int i = 3; i*i<n; i+=2){
            if(!notPrime[i]){
                for(int j = i*i; j <n; j+=2*i){
                    notPrime[j] = true;
                }
            }
        }
        for(int i = 3; i < n; i+=2){
            if(!notPrime[i])count++;
        }
        int[] primes = new int[count+2];
        primes[0] = 2;
        int index =1;
        for(int i = 3; i < n; i+=2){
            if(!notPrime[i])primes[index++] = i;
        }
        return primes;
    }

    public static void main(String[] args) {
        RepeatedSubString rss = new RepeatedSubString();
        System.out.println(rss.repeatedSubstringPattern("aaaaaaaaaaaa"));
    }
}
