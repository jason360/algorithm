package com.yawasoft.algorithm.array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array and an integer k, find the maximum for each and every contiguous subarray of size k.
 */
public class SlidingWindowMax {

    /**
     * We create a Deque, Qi of capacity k, that stores only useful elements of current window of k elements.
     * An element is useful if it is in current window
     * and is greater than all other elements on left side of it in current window. O(n).
     *
     * @param arr
     * @param k
     */
    public void printKMax(int[] arr, int k){
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();

        /* process first k elements */
        for(int i = 0; i < k; i++){
            /* remove elements that are not useful */
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);
        }

        /* process element k to n - 1 window by window */
        for(int j = k; j < n; j++){
            /* print max from last window */
            System.out.print(arr[dq.peek()] + " ");

            /* remove indexes out of current window */
            while(!dq.isEmpty() && dq.peek() <= j-k){
                dq.removeFirst();
            }

            /* remove elements that are not useful */
            while(!dq.isEmpty() && arr[j] >= arr[dq.peekLast()]){
                dq.removeLast();
            }

            dq.addLast(j);
        }

        /* print max for last window */
        System.out.print(arr[dq.peek()]);
        System.out.println();
    }

    public static void main(String[] args) {
        SlidingWindowMax swm = new SlidingWindowMax();
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        swm.printKMax(arr, 3); // expected result 3 3 4 5 5 5 6
        int[] arr1 = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        swm.printKMax(arr1, 4); // expected result 10 10 10 15 15 90 90
        int[] arr2 = {12, 1, 78, 90, 57, 89, 56};
        swm.printKMax(arr2, 3); // expected result 78 90 90 90 89
    }
}
