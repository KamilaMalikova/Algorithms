package com.company;

import java.util.Arrays;
import java.util.LinkedList;

public class Dijkstra {
    public static void FindShortestPath(Graph graph, int startVertex, int endVertex){
        int[][] matrix = graph.getAdjacencyMatrix();

        if (startVertex >= matrix.length || endVertex >= matrix.length) return;

        LinkedList<Integer> S = new LinkedList<>();
        S.add(startVertex);
        int[] D = new int[matrix.length];
        for (int i = 1; i < matrix.length; i++){
            D[i] = matrix[startVertex][i];
        }
        for (int i = 0; i < matrix.length; i++){
            System.out.println(Arrays.toString(D));
            int w = GetIndexOfMin(D);
            System.out.println(w);
            S.add(w);
            System.out.println(S);
            for (int v = 0; v<matrix[i].length; v++){
                System.out.println(v+": "+D[v] +" - "+D[w]+matrix[w][v]);
                if (D[v] >= D[w]+matrix[w][v]) D[v] =  D[w]+matrix[w][v];
                System.out.println(D[v]);
            }
        }
        System.out.println(Arrays.toString(D));
        System.out.println(S);
    }

    private static int GetIndexOfMin(int[] array){
        int j = 0;
        for (int i = 0; i< array.length; i++){
            if (array[i] > 0 && array[j] == 0){
                j = i;
            }
            else if (array[i] < array[j] && array[i] > 0) j = i;
        }
        return j;
    }
}
