package medium;

import utils.MyLog;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {
    public int totalFruit(int[] tree) {
        //sliding window思路，窗口中只能有两类数据
        //窗口长度任意，每次向后移动一个
        //最主要的问题是，维护窗户的起始位置
        //如果增加了新的数据，就要从当前窗户的起始位置开始，将不等于新增数据和新增数据前一个数据的都移出去
        //记录窗口的起始位置，窗口中的两个元素，窗口中两元素的最后索引位置
        //新增一个数据时，
        // 1.跟窗口中两元素不同，则计算此时窗口的长度，放入max；起始位置为两元素索引中小的那个+1，索引小的那个所指向的元素，从窗口两元素中删除，加入新的元素；更新新元素最后索引；
        //2. 跟窗口中某一元素相同，更新对应元素的最后索引位置；
        int windowBegin=0;
        int basket1=-1;
        int basket2=-1;
        int basket1Index = 0;
        int basket2Index = 0;
        int max = 0;
        for(int j = 0; j < tree.length; j++){
            if(basket1 < 0 ) {
                basket1 = tree[j];
                basket1Index = j;
            }else if(tree[j] != basket1 && basket2 <0){
                basket2 = tree[j];
                basket2Index = j;
            }else {
                if(tree[j] == basket1){
                    basket1Index =j;
                }else if(tree[j] == basket2){
                    basket2Index = j;
                }else {
                    MyLog.getLogger().info("current j :{}, windowBegin:{}", j, windowBegin);
                    max = Math.max(j-windowBegin, max);
                    windowBegin = basket1Index > basket2Index? basket2Index+1:basket1Index+1;
                    if(basket1Index > basket2Index){
                        basket2 = tree[j];
                        basket2Index = j;
                    }else {
                        basket1 = tree[j];
                        basket1Index = j;
                    }
                }
            }
        }
        System.out.println("windowBegin:" + windowBegin);
        return Math.max(max, tree.length - windowBegin);

//        Map<Integer, Integer> count = new HashMap<>();
//        int j = 0;
//        int max = 0;
//        for(int i = 0; i < tree.length ; i++){
//            count.merge(tree[i], 1, (a,b) ->(a + b));
//            while (count.keySet().size() > 2){
//                count.put(tree[j], count.get(tree[j])-1);
//                if(count.get(tree[j]) == 0) count.remove(tree[j]);
//                j++;
//            }
//           max = Math.max(max, i-j+1);
//        }
//        return max;
    }

    public static void main(String[] args) {
        FruitIntoBasket fib = new FruitIntoBasket();
        int[] test = new int[]{0,0,1,1};
        System.out.println(fib.totalFruit(test));
    }
}
