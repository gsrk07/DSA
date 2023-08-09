

/*
Problem Statement:
Sort an array of 0s, 1s and 2s
Given an array consisting of only 0s, 1s, and 2s.
Write a program to in-place sort the array without using inbuilt sort functions.
 ( Expected: Single pass-O(N) and constant space)
*/

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sort 0's 1's and 2's");
        System.out.println(" Dutch National Flag Algorithm");
    }

    public int[] bruteforce (int[] arr) {

        int c0 = 0;
        int c1 = 0;
        int c2 = 0;

        // first iteration we go and find out the counts of 0's, 1's and 2's
        for (int i = 0; i < arr.length; i++){

            if(arr[i] == 0){
                c0++;
            }
            else if(arr[i] == 1){
                c1++;
            }
            else {
                c2++;
            }

        }

        for(int i = 0; i < c0; i++){
            arr[i] = 0;
        }

        for(int i = c0; i < c0+c1; i++){
            arr[i] = 1;
        }

        for(int i = c0+c1; i < arr.length; i++){
            arr[i] = 2;
        }

        return arr;

        //TC is  O(N)
    }

    public ArrayList<Integer> optimal(ArrayList<Integer> arr){

        /* we take 3 pointers here and we want have 3 rules for these pointers.
         the 3 pointers are low, mid and high.

        0 to low-1 region of array will contain 0's which is to extreme left of the array
         low to mid-1 region will contain 1's
        high+1 to arr.length -1 will contain 2's which is to extreme right of the array
        from mid to high region is the region which is the unsorted part of the array which we will try making it as sorted.

        if(arr[mid] == 2 --> we swap it with arr[high] and decrement high since, arr[high+1] should contain 2
        if(arr[mid] == 0 -- > we swap it with arr[low] and increment low and mid since 0 to low-1 should only contain 0's
        if(arr[mid] == 1 --> we increment the mid pointer only since low to mid-1 should contain 1.

        we will run the loop till mid <= high.
        */

        int low = 0;
        int mid = 0;
        int high = arr.size()-1;

        while (mid <= high){

            if(arr.get(mid) == 0){

                // swap arr[mid] and arr[low]
                int temp = arr.get(low);
                arr.set(low,arr.get(mid));
                arr.set(mid,temp);

                low++;
                mid++;
            }

            else if(arr.get(mid) == 1){
                mid++;  // mid should move to the right since, low to mid-1 will contain 1.
            }

            else{

                // swap arr[mid] and arr[high]

                int temp = arr.get(high);
                arr.set(high,arr.get(mid));
                arr.set(mid,temp);

                high--;

            }
        }

        return arr;
    }

}
