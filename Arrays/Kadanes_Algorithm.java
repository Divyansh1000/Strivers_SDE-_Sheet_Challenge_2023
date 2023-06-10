package Arrays;
public class Kadanes_Algorithm {
    //.........OPTIMAL SOLUTION.......
    static long maxSubarraySum(int[] arr){
        long sum = 0 ; 
        long maxi = Long.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];

            if(sum < 0 ) 
            sum = 0 ;
            
            if(sum > maxi)
            maxi = sum ;


        }
        return maxi;
    }



    // //..............BETTER APPROACH.......
    // static int maxSubarraySum(int[] arr){
    //     int n = arr.length;

    //     int maxi = Integer. MIN_VALUE;

    //     for (int i = 0; i < n ; i++) {
    //         int sum = 0 ; 
    //         for (int j = i; j < n ; j++) {
    //             sum = sum + arr[j] ;
    //             maxi = Math.max(maxi , sum);
    //         }
    //     }

    //     if(maxi < 0 ) return 0;
    //     else
    //     return maxi;
    // }


    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
    
        long maxSum = maxSubarraySum(arr);
        System.out.println("The maximum subarray sum is: " + maxSum);

    
    }
}
