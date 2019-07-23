package com.yawasoft.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array A[] consisting 0s, 1s and 2s,
 * write a function that sorts A[].
 * The functions should put all 0s first, then all 1s and all 2s in last.
 */
public class SortZeroOneTwo {

    /**
     * If space is not a issue, i.e., the size of arr is limited, we can just create three arrays each contains just
     * 0s, 1s, or 2s. Then, iterate through the input array and put 0s, 1s, 2s into corresponding array.
     * Finally, concatenate three together.
     *
     * @param arr
     * @return
     */
    public int[] sort(int[] arr){
        List<Integer> zeros = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        List<Integer> twos = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            switch(arr[i]){
                case 0:
                    zeros.add(0);
                    break;
                case 1:
                    ones.add(1);
                    break;
                case 2:
                    twos.add(2);
                    break;
                default:
                    break;
            }
        }

        zeros.addAll(ones);
        zeros.addAll(twos);

        int[] ret = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            ret[i] = zeros.get(i);
        }
        return ret;
    }

    public int[] sortThreeWayPatition(int[] arr){
        int left =0;
        int mid = 0;
        int right = arr.length - 1;
        while( mid <= right){
            switch(arr[mid]){
                case 0:
                    swap(arr, left, mid);
                    left++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, right);
                    right--;
                    break;
                default:
                    break; // error handling if required
            }
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortZeroOneTwo seot = new SortZeroOneTwo();

        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        printArray(seot.sort(arr));
        printArray(seot.sortThreeWayPatition(arr));

        int[] arr1 = {2, 2, 2, 1, 1, 1, 1, 1, 0, 0, 0, 0};
        printArray(seot.sort(arr1));
        printArray(seot.sortThreeWayPatition(arr1));

        int[] arr2 = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2};
        printArray(seot.sort(arr2));
        printArray(seot.sortThreeWayPatition(arr2));
    }


}
