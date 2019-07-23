package com.yawasoft.algorithm.array;

import java.util.Arrays;

/**
 * Given an array and a number k where k is smaller than size of array,
 * we need to find the k’th smallest element in the given array.
 * It is given that all array elements are distinct.
 */
public class KthSmallest {

    /**
     * If quicksort is used,
     * The idea is, not to do complete quicksort, but stop at the point where pivot itself is k’th smallest element. Also, not to recur for both left and right sides of pivot, but recur for one of them according to the position of pivot.
     * The worst case time complexity of this method is O(n^2), but it works in O(n) on average.
     *
     * @param arr
     * @param k
     * @return
     */
    public int find(int[] arr, int k){
        Arrays.sort(arr);
        return arr[k-1];
    }

}
