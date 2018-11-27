package unclissified;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KSimilarString {
    public int kSimilarity(String A, String B) {
        if (A.equals(B)) return 0;
        Set<String> visited = new HashSet<>();
        visited.add(A);
        Queue<String> bfs = new LinkedList<>();
        bfs.add(A);
        int step = 0;
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                String temp = bfs.poll();
                if (temp.equals(B)) return step;
                int a = 0;  int b = 0;
                //找到第一个不相同的
                for (a = 0; a < temp.length() && temp.charAt(a) == B.charAt(a); a++) ;
                //跟后面的所有位置中不相同的，并且换完了能使a变正确的，交换
                //每次都能使正确的字母变多，保证算法的单调性
                //第一个不同的，必然要和另一个位置不对并且的交换，所以能遍历所有情况
                for (b = a + 1; b < temp.length(); b++) {
                    if (temp.charAt(b) != B.charAt(b) && temp.charAt(b) == B.charAt(a)) {
                        StringBuilder newState = new StringBuilder(temp);
                        newState.setCharAt(b, temp.charAt(a));
                        newState.setCharAt(a, temp.charAt(b));
                        if (visited.add(newState.toString())) {
                            bfs.offer(newState.toString());
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
}
