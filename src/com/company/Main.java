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
            DocDist docDist = new DocDist("1.txt", "2.txt");
        try {
            docDist.getDistinctOfFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
