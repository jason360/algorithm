package com.yawasoft.algorithm.array;

/**
 *  Given an array, reverse every sub-array formed by consecutive k elements.
 */
public class ReverseArrayinGroup {

    /**
     * Simple method with O(n)
     * @param arr
     * @param k
     */
    public void reverseInGroup(int[] arr, int k){
        for(int i = 0; i < arr.length; i += k){
            reverse(arr, i, i + k - 1);
        }
    }

    private void reverse(int[] arr, int left, int right){
        if(right > arr.length - 1){
            right = arr.length - 1;
        }
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseArrayinGroup rag = new ReverseArrayinGroup();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;

        rag.reverseInGroup(arr, k);

        for (int i = 0; i < arr.length; i++ ){
            System.out.print(arr[i] + " "); // expected result 3 2 1 6 5 4 8 7
        }
    }
}
