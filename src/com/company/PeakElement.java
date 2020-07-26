package com.company;

public class PeakElement {

    public static int Peak_1D_Array(int[] array, int low, int high){
        int mid = low+ (high-low)/2;
        if (low == high) return array[low];
        if (array[mid] >= array[mid-1] && array[mid] >= array[mid+1]){
            System.out.println(mid);
            return array[mid];
        }
        else if (array[mid] < array[mid-1] && array[mid-1] >= array[mid+1]){
            System.out.println(low+" : "+(mid-1)+" : "+high);
            return Peak_1D_Array(array, low, mid-1);
        }
        else if (array[mid] < array[mid+1] && array[mid+1] >= array[mid-1]){
            System.out.println(low+" : "+(mid+1)+" : "+(high));
            return Peak_1D_Array(array, mid+1, high);
        }
        return -1;
    }

    public static int Peak_2D_Array(int[][] array, int low, int high){
        int[] column = new int[array.length];
        int mid = low+(high-low)/2;
        int row = 0;
        for (int i = 1; i<array.length; i++){
            if (array[i][mid] >= array[i-1][mid]) row = i;
        }
        System.out.println(row+" : "+mid+" - "+array[row][mid]);
        System.out.println(low+" : "+mid+" : "+high);
        if (mid == high && mid== low) return array[row][mid];
        if (array[row][mid] >= array[row][mid-1] && array[row][mid] >= array[row][mid+1]){
            System.out.println((mid-1));
            return array[row][mid];
        }
        else if (array[row][mid] < array[row][mid-1] && array[row][mid-1] >= array[row][mid+1]){
            System.out.println(low+" : "+(mid-1)+" : "+high);
            return Peak_2D_Array(array, low, mid-1);
        }
        else {
            System.out.println(low+" : "+(mid+1)+" : "+high);
            return Peak_2D_Array(array, mid+1, high);
        }
    }
}
