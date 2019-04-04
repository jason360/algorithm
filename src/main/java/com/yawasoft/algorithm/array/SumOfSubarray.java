package com.yawasoft.algorithm.array;

/**
 * Problem:
 * <p>
 * A subarray of an array is a consecutive sequence of zero or more values taken out of that
 * array. For example, the array [1, 3, 7] has seven subarrays:
 * [ ]    [1]   [3]   [7]   [1, 3]   [3, 7]   [1, 3, 7]
 * Notice that [1, 7] is not a subarray of [1, 3, 7], because even though the values 1 and 7 appear in the array, they're not consecutive in the array. Similarly, the array [7, 3] isn't a
 * subarray of the original array, because these values are in the wrong order.
 * The sum of an array is the sum of all the values in that array. Your task is to write a
 * function that takes as input an array and outputs the sum of all of its subarrays. For example, given [1, 3, 7], you'd output 36, because
 * [ ] + [1] + [3] + [7] + [1, 3] + [3, 7] + [1, 3, 7] =
 * 0 + 1 + 3 + 7 + 4 + 10 + 11 = 36
 * </p>
 * Things to clarify:
 * <ul>
 *     <li>Is the array necessarily sorted?</li>
 *     <li>Can the array contain duplicate values?</li>
 *     <li>Do we have to worry about integer overflow?</li>
 *     <li>Are there any bounds on the number of elements in the array?</li>
 *     <li>How do we handle the empty array?</li>
 * </ul>
 *
 */
public class SumOfSubarray {

    /**
     * Naive solution: just list off all the subarrays and add all of them up;
     *
     * runs in time Θ(n^3), but only requires O(1) space.
     *
     * @param arr
     * @return
     */
    public int bruteForceSum(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++){
                for(int k = i; k <= j; k++){
                    sum += arr[k];
                }
            }
        }
        return sum;
    }

    /**
     *  The first element of the array will appear in n different subarrays
     * – each of them starts at the first position. The second element of the array will appear in
     * n­1 subarrays that begin at its position, plus  n­1 subarrays from the previous position
     * (there are n total intervals, of which one has length one and therefore won't reach the second element).
     *
     * the ith element
     * will open n – i new intervals (one for each length stretching out to the end) and, for each
     * preceding element, will overlap n – i of the intervals starting there. This means that the
     * total number of intervals overlapping element i is given by
     * (n – i)i + (n – i) = (n – i)(i + 1)
     *
     * This runs in O(n) time and uses only O(1) space
     */
    public int sumByNumOfOccurances(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i] * (arr.length - i) * (i + 1);
        }
        return sum;
    }

}
