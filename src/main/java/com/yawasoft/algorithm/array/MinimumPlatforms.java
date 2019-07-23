package com.yawasoft.algorithm.array;

import java.util.Arrays;

/**
 * Given arrival and departure times of all trains that reach a railway station,
 * find the minimum number of platforms required for the railway station so that no train waits.
 * We are given two arrays which represent arrival and departure times of trains that stop
 */
public class MinimumPlatforms {

    /**
     * We can solve the above problem in O(nLogn) time. The idea is to consider all events in sorted order.
     * Once we have all events in sorted order,
     * we can trace the number of trains at any time keeping track of trains that have arrived, but not departed.
     * @param arr
     * @param dep
     * @return
     */
    public int find(int[] arr, int[] dep){

        Arrays.sort(arr);
        Arrays.sort(dep);

        int platNeeded = 1;
        int tempNeeded = 1;
        int i = 1;
        int j = 0;
        while(i < arr.length && j < dep.length){
            if(arr[i] <= dep[j]){
                tempNeeded++;
                i++;
                if(tempNeeded > platNeeded){
                    platNeeded = tempNeeded;
                }
            }else {
                tempNeeded--;
                j++;
            }
        }
        return platNeeded;
    }

    public static void main(String[] args) {
        MinimumPlatforms mp = new MinimumPlatforms();
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(mp.find(arr, dep)); // expected 3
    }
}
