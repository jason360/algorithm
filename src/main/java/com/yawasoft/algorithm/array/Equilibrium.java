package com.yawasoft.algorithm.array;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Given an array A of N positive numbers.
 * The task is to find the position where equilibrium first occurs in the array.
 * Equilibrium position in an array is a position
 * such that the sum of elements before it is equal to the sum of elements after it.
 */
public class Equilibrium {

    /**
     * Works for positive integers only;
     *
     * @param arr
     * @return
     */
    public int equilibrium(int[] arr){
        int leftsum = 0;
        int rightsum = 0;
        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            if(leftsum > rightsum){
                rightsum += arr[right];
                right--;
            }else if(leftsum < rightsum){
                leftsum += arr[left];
                left++;
            }else{
                if(left == right){
                    return left;
                }
                leftsum += arr[left];
                rightsum += arr[right];
                left++;
                right--;
            }
        }
        return -1;
    }

    /**
     * work with negative values;
     *
     * @param arr
     * @return
     */
    public int equilibriumByTotalSum(int[] arr){
        int totalSum = 0;
        for(int i = 0; i < arr.length; i++){
            totalSum += arr[i];
        }

        int leftSum = 0;
        for(int i = 0; i < arr.length; i++){
            totalSum -= arr[i];
            if(totalSum == leftSum){
                return i;
            }
            leftSum += arr[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        Equilibrium e = new Equilibrium();

        int[] arr1 = {7, 2, 5, 4, 5};
        System.out.println(e.equilibrium(arr1));
        System.out.println(e.equilibriumByTotalSum(arr1));

        int[] arr2 = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println(e.equilibrium(arr2));
        System.out.println(e.equilibriumByTotalSum(arr2));
    }
}
