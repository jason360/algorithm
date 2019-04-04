package com.yawasoft.algorithm.floydwarshall;

/**
 * The Floyd Warshall Algorithm is for finding shortest distances between every pair of vertices
 * in a given edge weighted directed Graph.
 */
public class FloydWarshall {

    /**
     * If {\displaystyle w(i,j)} {\displaystyle w(i,j)} is the weight of the edge between vertices {\displaystyle i} i and {\displaystyle j} j, we can define {\displaystyle \mathrm {shortestPath} (i,j,k)} {\displaystyle \mathrm {shortestPath} (i,j,k)} in terms of the following recursive formula: the base case is
     *
     * {\displaystyle \mathrm {shortestPath} (i,j,0)=w(i,j)} {\displaystyle \mathrm {shortestPath} (i,j,0)=w(i,j)}
     * and the recursive case is
     *
     * {\displaystyle \mathrm {shortestPath} (i,j,k)=} {\displaystyle \mathrm {shortestPath} (i,j,k)=}
     * {\displaystyle \mathrm {min} {\Big (}\mathrm {shortestPath} (i,j,k-1),} {\displaystyle \mathrm {min} {\Big (}\mathrm {shortestPath} (i,j,k-1),}
     * {\displaystyle \mathrm {shortestPath} (i,k,k-1)+\mathrm {shortestPath} (k,j,k-1){\Big )}} {\displaystyle \mathrm {shortestPath} (i,k,k-1)+\mathrm {shortestPath} (k,j,k-1){\Big )}}.
     * This formula is the heart of the Floyd–Warshall algorithm. The algorithm works by first computing {\displaystyle \mathrm {shortestPath} (i,j,k)} {\displaystyle \mathrm {shortestPath} (i,j,k)} for all {\displaystyle (i,j)} (i,j) pairs for {\displaystyle k=1} k=1, then {\displaystyle k=2} k=2, etc. This process continues until {\displaystyle k=N} k=N, and we have found the shortest path for all {\displaystyle (i,j)} (i,j) pairs using any intermediate vertices.
     *
     * @param graph
     * @param numOfVertex
     * @return
     */
    public int[][] floyedWarshall(int[][] graph, int numOfVertex){
        int[][] dist = new int[numOfVertex][numOfVertex];

        /* initialize dist to original graph */
        for(int i = 0; i < numOfVertex; i++){
            for(int j = 0; j < numOfVertex; j++){
                dist[i][j] = graph[i][j];
            }
        }

        for(int k = 0; k < numOfVertex; k++){
            for(int i = 0; i < numOfVertex; i++){
                for(int j = 0; j < numOfVertex; j++){
                    if(Integer.MAX_VALUE != dist[i][k] && Integer.MAX_VALUE != dist[k][j]) {
                        int kdist = dist[i][k] + dist[k][j];
                        if (kdist < dist[i][j]) {
                            dist[i][j] = kdist;
                        }
                    }
                }
            }
        }

        return dist;
    }

    /**
     * Assume the Integer.MAX_VALUE represents no path between two vertices.
     *
     * @param dist
     */
    public void print(int[][] dist){
        for(int i = 0; i < dist.length; i++){
            for(int j = 0; j < dist[i].length; j++){
                System.out.print(Integer.MAX_VALUE == dist[i][j] ? "NA" : dist[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 3, 5, 8, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 0, 21, 34, 55},
                {Integer.MAX_VALUE, 4, 0, 8, 10},
                {Integer.MAX_VALUE, 3, 5, 0, 9},
                {Integer.MAX_VALUE, 9, Integer.MAX_VALUE, 15, 0}};
        FloydWarshall floyd = new FloydWarshall();
        floyd.print(floyd.floyedWarshall(graph, 5));
    }
}
