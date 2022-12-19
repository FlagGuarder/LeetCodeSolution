package graph.Solution1971;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        int[][] adj = new int[n][n];
        boolean[] visited = new boolean[n];
        for (int[] edge : edges){
            int x = edge[0];
            int y = edge[1];
            adj[x][y] = 1;
            adj[y][x] = 1;
        }

        Queue<Integer> queue = new ArrayDeque();
        queue.add(source);
        visited[source]=true;
        while (!queue.isEmpty()){
            Integer vertex = queue.poll();
            if (vertex==destination){
                break;
            }
            for(int i=0; i < adj[vertex].length;i++){
                if(adj[vertex][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }

        }
        return visited[destination];
    }
}
