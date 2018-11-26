import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    //使用宽度优先搜索，一定会找到变化步数最小的那条路径
    // 因为是一层一层搜索的、所以最先搜索到的一定是层数最低的，即变化步数最少的
    public int slidingPuzzle(int[][] board) {
        String result = "123450";
        StringBuilder current = new StringBuilder();
        for(int i=0; i < board.length; i++){
            for(int j =0; j< board[0].length; j++){
                current.append(board[i][j]);
            }
        }
        if(result.equals(current.toString()))return 0;

        Set<String> visitied = new HashSet<>();
        visitied.add(current.toString());
        int[][] moves=new int[][]{{1, 3},{0,2,4},{1, 5},{0,4},{1,3,5},{2,4}};
        Queue<String> queue = new LinkedList<>();
        queue.add(current.toString());
        int moveStep = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i =0; i< size; i++){
                String currentString = queue.poll();
                int index0 = currentString.indexOf('0');
                for(int each :moves[index0]){
                    String newString = swap(currentString, index0, each);
                    if(newString.equals(result))return moveStep+1;
                    if(!visitied.contains(newString)){
                        visitied.add(newString);
                        queue.offer(newString);
                    }
                }
            }
            moveStep++;
        }
        return -1;
    }

    private String swap(String currentString, int index0, int each) {
        StringBuilder sb = new StringBuilder(currentString);
        sb.setCharAt(index0, currentString.charAt(each));
        sb.setCharAt(each, currentString.charAt(index0));
        return sb.toString();
    }


}
