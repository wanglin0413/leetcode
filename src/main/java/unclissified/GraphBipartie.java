package unclissified;

import java.util.Arrays;

public class GraphBipartie {
    //https://leetcode.com/problems/is-graph-bipartite/description/
    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        int[] colors = new int[length];
        Arrays.fill(colors, -1);

        for (int i = 0;i< length; i++){
            if(colors[i] == -1 && !isValid(graph, colors, 0,i)){
                return false;
            }
        }
         return true;
    }

    private boolean isValid(int[][] graph, int[] colors, int color, int node) {
        if(colors[node] != -1){
            return colors[node] == color;
        }
        colors[node] = color;
        for(int each:graph[node]){
            if(!isValid(graph, colors, 1-color, each)){
                return false;
            }
        }
        return true;
    }


}
