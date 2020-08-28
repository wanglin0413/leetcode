package easy;

import java.util.*;


public class KthLargest {
    PriorityQueue<Integer> queue;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for(int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        if(queue.size() < k) {
            queue.add(val);
        } else if(queue.peek() < val) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargest kl = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(kl.add(3));
        System.out.println(kl.add(5));
        System.out.println(kl.add(10));
        System.out.println(kl.add(9));
        System.out.println(kl.add(4));
    }

}
