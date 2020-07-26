package com.company;

public class Karatsuba {
    public void Multiply(int[] A, int[] B){
        int bitness = 10;
        int a = makeNum(getSubArray(A, true), bitness);
        int b = makeNum(getSubArray(A, false), bitness);
        int c = makeNum(getSubArray(B, true), bitness);
        int d = makeNum(getSubArray(B, false), bitness);


    }
    private int[] getSubArray(int[] array, boolean isStart){
        int newArrayLength;
        int[] newArray;
        if (isStart){
            if (array.length%2 == 1){
                newArrayLength = array.length/2+1;
            }
            else {
                newArrayLength = array.length/2;
            }
            newArray = new int[newArrayLength];
            for (int i = 0; i < newArrayLength; i++) {
                newArray[i] = array[i];
            }
        }
        else {
            newArrayLength = array.length/2;
            newArray = new int[newArrayLength];
            int j = newArrayLength;
            for (int i = 0; i < newArrayLength; i++) {
                newArray[i] = array[j];
                j++;
            }
        }
        return newArray;
    }

    private int makeNum(int[] a, int bitness){
        int num = 0;
        for (int i = 0; i < a.length; i++){
            num+=a[i]*Math.pow(bitness, i);
        }
        return num;
    }
}
