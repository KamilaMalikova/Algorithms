package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

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

    public static void CountingSort(int[] array){
        int[] output = new int[array.length];
        int[] count = new int[array.length];

        for (int i = 0; i< array.length; i++){
            count[array[i]]+=1;
        }

        for (int i = 1; i< count.length; i++){
            count[i]+=count[i-1];
        }

        for (int i = 0; i<array.length; i++){
            output[count[array[i]]-1] = array[i];
            --count[array[i]];
        }
        System.out.println(Arrays.toString(output));
    }

    //O(n+d(n+k)) -> O(n(d+1)+dk) -> (O(nd+dk)) -> O(d(n+k))
    public  static void radixsort(int arr[])
    {
        int n = arr.length;
        int m = getMax(arr, n); //O(n)

        for (int exp = 1; m/exp > 0; exp *= 10) //O(d(n+k))
            countSort(arr, n, exp);
        System.out.println(Arrays.toString(arr));
    }

    //O(n)
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    //O(n+k)
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }


}
