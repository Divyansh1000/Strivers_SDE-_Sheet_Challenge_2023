package Arrays_2;
public class Repeating_Missing_Number {

    static int[] find_Repeating_Missing_No(int[] arr){
        long n = arr.length;
        long SumN = (n * (n + 1)) / 2;
        long Sum2N  = (n * (n+1)*(2*n +1 )) / 6;
        long Sum = 0 , Sum2 = 0 ;
        for (int i = 0; i < n; i++) {
            //sum of n array elements . and sum of square of n array elements      Sum
            Sum += arr[i];
            Sum2 += (long) arr[i] * (long) arr[i];
        }
        long val1 = Sum - SumN ;
        long val2 = Sum2 - Sum2N;

        val2 = val2 / val1; 
        long x = (val1 + val2) / 2;
        long y = x - val1 ;
        
        int[] ans = {(int)x, (int)y};
        return ans;
    }



// //..........BETTER APPROACH.............
//     static int[] find_Repeating_Missing_No(int[] arr){
//         int n = arr.length;
//         int repeating = -1;
//         int missing = -1;
    
//         int[] hash = new int[n+1];
//         for (int i = 0; i < n; i++) {
//             hash[arr[i]]++;
//         }
        
//         for (int i = 1; i <= n; i++) {
//             if(hash[i] == 2) repeating = i;
//             else if(hash[i] == 0) missing = i ;

//             if(repeating != -1 &&  missing != -1)
//             break;
//         }
    
    
//         int[] ans = {repeating, missing};
//         return ans;
//     }

    // //............BRUTE FORCE APPROACH............
    // static int[] find_Repeating_Missing_No(int[] arr) {
    //     int n = arr.length;
    //     int repeating = -1, missing = -1;

    //     for (int i = 1; i <= n; i++) {
    //         int count = 0;
    //         for (int j = 0; j < n; j++) {
    //             if (arr[j] == i)
    //                 count++;
    //         }
    //         if (count == 0) missing = i;
    //         else if (count == 2) repeating = i;

    //         if (repeating != -1 && missing != -1)
    //         break;
    //     }

    //     int[] ans = { repeating, missing };
    //     return ans;

    // }

    public static void main(String[] args) {
        int[] arr = { 3, 1, 2, 5, 4, 6, 7, 5 };
        int[] ans = find_Repeating_Missing_No(arr);

        System.out.println("The repeating and missing numbers are: {"
                + ans[0] + ", " + ans[1] + "}");
    }
}
