package Arrays;

public class Sort_Array_0s_1s_2s {

    static void sortArray(int[] arr ){
        int n = arr.length;
        int low = 0 ; 
        int mid = 0 ;
        int high = n-1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;  
                mid++;

            } else if (arr[mid] == 1) {
                mid++;
                
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        
        int arr[] = {0, 2, 1, 2, 0, 1};
        
        sortArray(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
