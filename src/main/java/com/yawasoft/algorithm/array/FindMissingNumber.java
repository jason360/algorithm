package com.yawasoft.algorithm.array;

/**
 * You are given a list of n-1 integers and these integers are in the range of 1 to n.
 * There are no duplicates in list. One of the integers is missing in the list.
 * Write an efficient code to find the missing integer.
 */
public class FindMissingNumber {

    public int findBySum(int[] arr){
        int n = arr.length + 1;
        int sum = n * (n + 1) / 2;
        for(int i = 0; i < arr.length; i++){
            sum -= arr[i];
        }
        return sum;
    }

    /**
     * 1) XOR all the array elements, let the result of XOR be X1.
     *   2) XOR all numbers from 1 to n, let XOR be X2.
     *   3) XOR of X1 and X2 gives the missing number.
     *
     * @param arr
     * @return
     */
    public int findByXor(int[] arr){
        int n = arr.length + 1;
        int x1 = arr[0];
        for(int i = 1; i < arr.length; i++){
            x1 ^= arr[i];
        }

        int x2 = 1;
        for(int i = 2; i <= n; i++){
            x2 ^= i;
        }

        return x1 ^ x2;
    }

    public static void main(String[] args) {
        FindMissingNumber fmn = new FindMissingNumber();
        int[] arr = {1, 2, 3, 5};
        System.out.println(fmn.findBySum(arr)); // output 4
        System.out.println(fmn.findByXor(arr)); // output 4

        int[] arr1 = {1, 3, 5, 2, 4, 6};
        System.out.println(fmn.findBySum(arr1)); // output 7
        System.out.println(fmn.findByXor(arr1)); // output 7
    }
}
