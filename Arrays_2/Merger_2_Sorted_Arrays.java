package Arrays_2;

import java.util.Arrays;

public class Merger_2_Sorted_Arrays {
    
    //.....OPTIMAL APPROACH.........   
    public static void merge(long[] arr1, long[] arr2, int n, int m) {
        int left = n-1 ;
        int right = 0;
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;

                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);

    }

    // //..........BRUTE FORCE APPROACH...........
    // public static void merge(long[] arr1, long[] arr2, int n, int m) {
    // long[] arr3 = new long[n+m];
    // int left = 0;
    // int right = 0;
    // int index = 0;

    // while(left < n && right < m){
    // if(arr1[left ] <= arr2[right]){
    // arr3[index] = arr1[left];
    // left++ ; index++ ;
    // }
    // else{
    // arr3[index] = arr2[right];
    // right++; index++;
    // }
    // }
    // while(left < n ){
    // arr3[index++] = arr1[left++];
    // }
    // while(right < m ){
    // arr3[index++] = arr2[right++];
    // }

    // for (int i = 0; i < n+m ; i++) {
    // if(i< n ) {arr1[i] = arr3[i];}
    // else {arr2[i-n] = arr3[i];}
    // }

    // }

    public static void main(String[] args) {
        // long[] arr1 = { 1, 4, 8, 10 };
        // long[] arr2 = { 2, 3, 9 };
        
        long[] arr1 = { 1, 4, 8, 1 };
        long[] arr2 = { 2, 3, 9 };
        

        int n = 4, m = 3;

        merge(arr1, arr2, n, m);

        System.out.println("The merged arrays are:");

        System.out.print("arr1[] = ");

        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }

        System.out.print("\narr2[] = ");

        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }

}
