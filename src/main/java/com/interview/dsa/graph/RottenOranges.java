package com.interview.dsa.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class RottenOranges {

    public static void main(String[] args) {

        int[][] arr = {{2,1,1},{1,1,0},{0,1,1}};

        int[] g = IntStream.iterate(0, i -> i < 10, i -> i + 1)

                .toArray();

        System.out.println(Arrays.toString(g));
        System.out.println(orangesRotting(arr));


    }
    public static int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }
            }
        }

        int min = 0;
        int[] rows = {-1, 0, 1, 0};
        int[] cols = {0, 1, 0, -1};
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            int r = pair.row;
            int c = pair.col;
            int time = pair.time;
            min = Math.max(min, time);
            for(int i = 0; i < 4; i++) {
                int nrow = r + rows[i];
                int ncol = c + cols[i];
                if(nrow >= 0 &&
                        nrow < n &&
                        ncol >= 0 &&
                        ncol < m &&
                        visited[nrow][ncol] == 0 &&
                        grid[nrow][ncol] == 1
                ) {
                    queue.add(new Pair(nrow, ncol, time + 1));
                    visited[nrow][ncol] = 2;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j] != 2 && grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return min;
    }

    private static class Pair {
        int row;
        int col;
        int time;

        Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    ArrayList<Integer> dfs(ArrayList<Integer>[] adjList) {
        // add your logic here
        ArrayList<Integer> res = new ArrayList<>();
        dsf(0, -1, adjList, res);

        return res;
    }

    private void dsf(
            int node,
            int parent,
            ArrayList<Integer>[] adjList,
            ArrayList<Integer> res) {

        res.add(node);


        for (Integer adjNode: adjList[node]) {
            if (node != parent) {
                dsf(adjNode, node, adjList, res);
            }
        }

    }
}
