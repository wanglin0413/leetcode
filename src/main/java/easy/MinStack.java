package easy;

import java.util.ArrayList;

public class MinStack {
    /** initialize your data structure here. */
    int min;
    int minCount;
    int size;
    ArrayList<Integer> list;
    public MinStack() {
        list = new ArrayList<>();
        min = Integer.MAX_VALUE;
        minCount = 0;
        size = 0;
    }

    public void push(int x) {
        list.add(size++, x);
        if(x < min){
            min = x;
            minCount = 1;
        }else if(x == min){
            minCount++;
        }
    }

    public void pop() {
        int top = list.get(--size);
        if(top == min){
            if(minCount > 1){
                minCount--;
            }else {
                reCalcuMin();
            }
        }
    }

    private void reCalcuMin() {
        min = Integer.MAX_VALUE;
        minCount = 0;
        for(int i =0; i < size; i++){
            int cur = list.get(i);
            if(cur < min){
                min = cur;
                minCount = 1;
            }else if(cur == min){
                minCount++;
            }
        }
    }

    public int top() {
        return list.get(size -1);
    }

    public int getMin() {
        return min;
    }
}
