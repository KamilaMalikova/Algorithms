package com.company;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Dijkstra {
    public static void FindShortestPath(Graph graph, int[] R, int startVertex, int endVertex){
        Integer[][] matrix = graph.getAdjacencyMatrix();

        if (startVertex >= matrix.length || endVertex >= matrix.length) return;

        LinkedList<Integer> S = new LinkedList<>();
        S.add(startVertex);
        Integer[] D = new Integer[matrix.length];
        for (int i = 1; i < matrix.length; i++){
            D[i] = matrix[startVertex][i];
        }
        while (S.size() <= matrix.length){
            System.out.println(Arrays.toString(D));
            int w = GetIndexOfMin(D, R);
            System.out.println("Min: "+w);
            S.add(w);
            R[w] = -1;
            System.out.println(S);
            System.out.println(Arrays.toString(R));
            for (int v: R){
                if (v == -1) continue;
                //System.out.println(v+": "+D[v] +" - "+D[w]+" - "+matrix[w][v]);
                if(matrix[w][v] != null)
                    if (D[v] == null && matrix[w][v] != null) D[v] = matrix[w][v];
                    else if (matrix[w][v] != null)
                        if (D[v] >= D[w]+matrix[w][v]) D[v] =  D[w]+matrix[w][v];
                System.out.println(D[v]);
            }
        }
        System.out.println(Arrays.toString(D));
        System.out.println(S);
    }

    private static int GetIndexOfMin(Integer[] array, int[] R){
        int j = 0;
        for (int i = 0; i< array.length; i++){
            if (array[i] != null && R[i] != -1){
                if (array[j] == null) j = i;
                else if (array[i] < array[j] && array[i] > 0) j = i;
            }
        }
        return j;
    }
}
