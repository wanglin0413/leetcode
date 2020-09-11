package easy;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumber {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if(selfDividable(i)){
                result.add(i);
            }
        }
        return result;
    }

    private boolean selfDividable(int num) {
        if(num < 10)return true;
        int cur = num;
        while (cur != 0){
            int remain = cur % 10;
            if(remain == 0 || num % remain != 0)return false;
            cur = cur /10;
        }
        return true;
    }
}
