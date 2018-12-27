package easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        //实质上是找环算法，Floyd Cycle detection algorithm
        int fast = n, slow = n;
        while (true){
            slow = newNum(slow);
            fast = newNum(fast);
            fast = newNum(fast);
            if(slow == 1 || fast == 1)return true;
            if(slow == fast)return false;
        }
//        Set<Integer> counted = new HashSet<>();
//        while (true){
//            int newNum = 0;
//            while (n != 0){
//                int tmp = n % 10;
//                newNum += tmp*tmp;
//                n /= 10;
//            }
//            if(newNum == 1)return true;
//            if(counted.contains(newNum))return false;
//            counted.add(newNum);
//            n = newNum;
//        }

    }
    int newNum(int n){
        int newNum = 0;
            while (n != 0){
                int tmp = n % 10;
                newNum += tmp*tmp;
                n /= 10;
            }
            return newNum;
    }

    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(10));
    }
}
