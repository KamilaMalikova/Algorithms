package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
//        int[] array = new int[10000];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt(1000);
//        }
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(Sort.InsertionSort(array)));
//
//      //  System.out.println(Sort.BinarySearchRecursion(array, 90, 0, array.length-1));
//        System.out.println(PeakElement.Peak_1D_Array(array, 0, array.length-1));

//        int[][] array2D = new int[10][100];
///*        int[][] array2D = { {10,8,10,10},
//                            {14,13,12,11},
//                            {15,9,11,21},
//                            {16,17,19,20}};*/
//        for (int i = 0; i <array2D.length; i++){
//            for (int j = 0; j< array2D[i].length; j++){
//                array2D[i][j] = random.nextInt(1000);
//                System.out.print(array2D[i][j]+"  ");
//            }
//            System.out.println();
//        }
//        System.out.println(PeakElement.Peak_2D_Array(array2D, 0, array2D[0].length-1));


//        DocDist docDist = new DocDist("1.txt", "2.txt");
//        try {
//            docDist.getDistinctOfFiles();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //heap
//        int[] array2 = new int[1000];
//        for (int i = 0; i < array2.length; i++){
//            array2[i] = random.nextInt(500);
//        }
//        //int[] array = {27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
//        System.out.println(Arrays.toString(Heaps.heap_sort(array2)));

        //Binary tree search
//        int size = 1000;
        BST<Integer> bst = new BST<>();
//        for (int i = 0; i < size; i++){
//            bst.insert(random.nextInt(500));
//        }

        bst.insert(362);
        bst.insert(400);
        bst.insert(117);
        bst.insert(299);
        bst.insert(51);
        bst.insert(271);
        bst.insert(302);
        bst.insert(463);
        bst.insert(102);
        bst.insert(73);
        bst.insert(340);
        bst.find(340);
        bst.Min(51);
        bst.Max(299);
        bst.successor(299);
        bst.delete(271);
        bst.find(271);
    }
}
