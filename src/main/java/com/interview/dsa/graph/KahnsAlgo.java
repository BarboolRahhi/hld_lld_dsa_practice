package com.interview.dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnsAlgo {
    public static void main(String[] args) {

    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {


        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] topoSort = new int[V];
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoSort[index] = node;
            index++;
            for (int it : adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) queue.add(it);
            }
        }

        return topoSort;
    }

}
