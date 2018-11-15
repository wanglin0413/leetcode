package easy;

public class GuessNumber  {
    public int guessNumber(int n) {
        if(n ==1)return 1;
        long low = 0;
        long high = n;
        long guess = n >> 1;
        int result = guess((int)guess);
        System.out.println("first guess:" + guess);
        while (result != 0){
            if(result == 1){
                low = guess+ 1;
                System.out.println("too small, from " + low + " to " + high);
            }else {
                high = guess;
                System.out.println("too high, from " + low + " to " + high);
            }
            guess = (low + high) >> 1;
            System.out.println("guess is " + guess);
            result = guess((int)guess);
            if(guess <=0)break;
        }
        return (int)guess;
    }

    private int guess(int guess) {
        if(guess < 6 ) return 1;
        if(guess == 6) return 0;
        return -1;
    }

    public static void main(String[] args) {
        GuessNumber gn = new GuessNumber();
        gn.guessNumber(10);
    }
}
