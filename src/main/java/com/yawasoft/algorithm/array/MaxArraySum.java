package com.yawasoft.algorithm.array;

/**
 * Given an array find the maximum subarray sum.
 *
 * Kadane’s Algorithm
 *
 * Kadane's algorithm begins with a simple inductive question:
 * if we know the maximum subarray sum ending at position i (call this B_{i}),
 * what is the maximum subarray sum ending at position i+1 (equivalently, what is B_{{i+1}})?
 * either the maximum subarray sum ending at position i+1 includes the maximum subarray sum ending at position i as a prefix,
 * or it doesn't (equivalently, B_{i+1}=\max(A_{i+1},A_{i+1}+B_{i})}, where A_{i+1} is the element at index i+1).
 *
 */
public class MaxArraySum {

    public int maxSubarray(int[] arr){
        int final_max = Integer.MIN_VALUE;
        int temp_max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(temp_max < 0 && arr[i] < 0){
                temp_max = arr[i];
            }else {
                temp_max = Math.max(arr[i], temp_max + arr[i]);
            }
            final_max = Math.max(final_max, temp_max);
        }
        return final_max;
    }

    /**
     * If all elements are negative, the result is an zero length subarray (with implicit sum 0)
     *
     * @param arr
     * @return
     */
    public MaxResult maxSubarrayWithIndex(int[] arr){
        int current_max = 0;
        int current_start = 0;

        MaxResult result = new MaxResult();

        for(int i = 0; i < arr.length; i++){
            current_max = Math.max(arr[i], current_max + arr[i]);
            if(current_max == arr[i]){
                current_start = i;
            }
            result.max = Math.max(result.max, current_max);
            if(result.max == current_max){
                result.startIndex = current_start;
                result.endIndex = i;
            }
        }
        return result;
    }

    public static class MaxResult {
        int max = 0;
        int startIndex = 0;
        int endIndex = 0;

        @Override
        public String toString() {
            return "MaxResult{" +
                    "max=" + max +
                    ", startIndex=" + startIndex +
                    ", endIndex=" + endIndex +
                    '}';
        }
    }

    public static void main(String[] args) {
        MaxArraySum mas = new MaxArraySum();
        int[] arr1 = {1, 2, 3, -2, 5};
        System.out.println(mas.maxSubarray(arr1)); // expected result 9
        System.out.println(mas.maxSubarrayWithIndex(arr1)); // expected result {9, 0, 4}
        int[] arr2 = {-1, -2, -3, -4};
        System.out.println(mas.maxSubarray(arr2)); // expected result -1
        System.out.println(mas.maxSubarrayWithIndex(arr2)); // expected result {0, 0, 0}
    }

}
