package com.company;

public class Sort {
    public static int[] InsertionSort(int[] array){
        for (int j = 1; j < array.length; j++){
            int key = array[j];
            int i = j -1;
            while (i>=0 && array[i] > key){
                array[i+1] = array[i];
                i = i-1;
            }
            array[i+1] = key;
        }
        return array;
    }

    public static int[] InsertionSort(int[] array, boolean non_increasing){
        for (int j = 1; j < array.length; j++){
            int key = array[j];
            int i = j-1;
            while (i >= 0 && array[i] < key){
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = key;
        }
        return array;
    }

    public static int BinarySearch(int[] array, int value){
        int start = 0;
        int end = array.length-1;
        while (start <= end){
            int mid = start+(end-start)/2;
            if (array[mid] == value) return mid;
            else if (array[mid] > value){
                end = mid-1;
            }
            else if (array[mid] < value) start= mid+1;
        }
        return -1;
    }

    public static int BinarySearchRecursion(int[] array, int value, int low, int high){
        int mid = low+(high-low)/2;
        if (low > high) return -1;
        if (array[mid] == value) return mid;
        else if (value < array[mid] ){
            return BinarySearchRecursion(array, value, low, mid-1);
        }
        else if (value > array[mid]) {
            return BinarySearchRecursion(array, value, mid+1, high);
        }
        return -1;
    }
}
