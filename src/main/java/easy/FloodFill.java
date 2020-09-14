package easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()){
            checkAndUpdate(image, queue, oldColor, newColor);
        }
        return image;
    }

    private void checkAndUpdate(int[][] image, Queue<int[]> queue, int oldColor, int newColor) {
        int[] pivot = queue.poll();
        if(pivot[0] > 0 && image[pivot[0]-1][pivot[1]] == oldColor && image[pivot[0]-1][pivot[1]] != newColor){
            queue.offer(new int[]{pivot[0] -1, pivot[1]});
            image[pivot[0]-1][pivot[1]] = newColor;
        }
        if(pivot[1] > 0 && image[pivot[0]][pivot[1]-1] == oldColor && image[pivot[0]][pivot[1]-1] != newColor){
            queue.offer(new int[]{pivot[0], pivot[1]-1});
            image[pivot[0]][pivot[1]-1] = newColor;
        }
        if(pivot[0] < image.length-1 && image[pivot[0]+1][pivot[1]] == oldColor && image[pivot[0]+1][pivot[1]] != newColor){
            queue.offer(new int[]{pivot[0]+1, pivot[1]});
            image[pivot[0]+1][pivot[1]] = newColor;
        }
        if(pivot[1] < image[0].length-1 && image[pivot[0]][pivot[1]+1] == oldColor && image[pivot[0]][pivot[1]+1] != newColor){
            queue.offer(new int[]{pivot[0], pivot[1]+1});
            image[pivot[0]][pivot[1]+1] = newColor;
        }
    }

    public static void main(String[] args) {
        FloodFill ff = new FloodFill();
        int[][] image = new int[][]{{0,0,0},{0,1,1}};
        ff.floodFill(image, 1,1, 1);

        for(int[] eachRow : image){
            System.out.println(Arrays.toString(eachRow));
        }
    }

}
