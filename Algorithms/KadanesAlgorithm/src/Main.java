
// Kadane's Algorithm

// Problem statement:

/*
 Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello Kadane Algorithm");
    }

    public int bruteforce(int[] arr) {

        // [-2,1,-3,4,-1,2,1,-5,4]
        // output is 6 as it is the maxsubarray sum

        // we take 2 loops and find the max subarray sum of all the possible sub arrays

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){

            int curr_sum = 0;

            for (int j = i; j < arr.length; j++){

                curr_sum += arr[j];

                ans = Math.max(ans,curr_sum);
            }
        }

        return ans;

        // TC is O(N2), SC IS O(1)
    }

    // Optimal approach

    /* we calculate max sub array sum using kadane's algorithm, where we are not considering 2 loops for subarrays
    we will be simply calculating the sub array sum by adding each element of the given array.
    .. now, if at any stage the sum becomes negative, we wont consider that sub array sum as negative sum
    will not help in any contribution to max sum. so we make the curr_sum as 0 and move to next subarray.
     */

    public int optimal(int[] arr){

        int max_sum = Integer.MIN_VALUE;

        int curr_Sum = 0;

        for(int i = 0; i < arr.length; i++){

            curr_Sum += arr[i];

            if(curr_Sum > max_sum){

                max_sum = Math.max(max_sum,curr_Sum);

            }

            if(curr_Sum < 0){
                curr_Sum = 0;
            }

        }

        return max_sum;


    }
}
