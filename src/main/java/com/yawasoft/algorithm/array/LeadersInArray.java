package com.yawasoft.algorithm.array;

/**
 * Write a program to print all the LEADERS in the array.
 * An element is leader if it is greater than all the elements to its right side.
 * And the rightmost element is always a leader.
 * For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
 */
public class LeadersInArray {
    /**
     * Scan all the elements from right to left in array and keep track of maximum till now.
     * When maximum changes it’s value, print it.
     * @param arr
     */
    public void printLeaders(int[] arr){
        int i = arr.length - 1;
        int max = arr[i];
        System.out.print(max);
        while(i >= 0){
            if(arr[i] > max){
                max = arr[i];
                System.out.print(" " + arr[i]);
            }
            i--;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LeadersInArray lia = new LeadersInArray();
        int[] arr1 = {16, 17, 4, 3, 5, 2};
        lia.printLeaders(arr1);
    }
}
