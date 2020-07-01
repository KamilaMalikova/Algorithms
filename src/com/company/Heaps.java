package com.company;

public class Heaps {

    public static int[] max_heapify(int[] A, int n, int i){
        int l = i*2+1;
        int r = i*2+2;
        int largest = i;
        int heap_size = n;
        System.out.println(heap_size);
        if (l < heap_size && A[l] > A[largest]){
            largest = l;
        }
        if (r < heap_size && A[r] > A[largest]){
            largest = r;
        }
        if (largest != i){
            int node = A[i];
            A[i] = A[largest];
            A[largest] = node;
            max_heapify(A, n, largest);
        }
        int[] array = A;
        return A;
    }

    public static int[] heap_sort(int[] A){
        int n = A.length;
        //O(n)
        for (int i = n/2-1; i>=0; i--){
            //O(lg(n))
            A = max_heapify(A, n, i);
        }

        for (int i = n-1; i>=0; i--){
            int node = A[i];
            A[i] = A[0];
            A[0] = node;
            A = max_heapify(A, i, 0);
        }
        return A;
    }

}
