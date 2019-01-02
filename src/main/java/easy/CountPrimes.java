package easy;

public class CountPrimes {
    public int countPrimes(int n) {
        //初始都是false，即都是质数
      boolean[] notPrime = new boolean[n];
      int count = 0;
        //跳过偶数，数的时候也跳过偶数
        //标记的时候，外循环只到根号n，需要最后数一遍
        for(int i = 3; i*i<n; i+=2){
          //如果是质数
          if(!notPrime[i]){
              //从i*i开始标记，因为i*小于i 的数，必定在之前已经标记过了，每次+2*i也是为了过滤掉偶数
              for(int j = i*i; j <n; j+=2*i){
                  notPrime[j] = true;
              }
          }
      }
      for(int i = 3; i < n; i+=2){
          if(!notPrime[i])count++;
      }
        return count+1;
    }


    public static void main(String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(10));
    }
}
