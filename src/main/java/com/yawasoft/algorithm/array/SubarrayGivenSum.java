package com.yawasoft.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
 */
public class SubarrayGivenSum {

    /**
     * Print out start index and end index of subarray that its sum equals to k;
     *
     * Let sum(i) be the sum of first i element, and sum(j) be the sum of first j element,
     * If sum(j) - sum(i) = k, then sum from element i to j must equals to k;
     *
     * @param arr
     * @param k
     */
    public static void findStartEndIndex(int[] arr, int k){
        Map<Integer,Integer> sumWithIndex = new HashMap<>();
        sumWithIndex.put(0, 0);
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sumWithIndex.containsKey(sum - k)){
                System.out.println((sumWithIndex.get(sum-k) +1) + " " + (i+1));
                return;
            }
            sumWithIndex.putIfAbsent(sum, i+1);
        }
    }

    /**
     * Test case:
     * <ul>
     *     <li>1 2 3 7 5, k=12, output: 2 4</li>
     *     <li>1 2 3 4 5 6 7 8 9 10, k=15, output: 1 5</li>
     * </ul>
     * @param args
     */
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,7,5};
        SubarrayGivenSum.findStartEndIndex(arr1, 12);
        int[] arr2 = {1,2,3,4,5, 6,7,8,9,10};
        SubarrayGivenSum.findStartEndIndex(arr2, 15);
    }

}
