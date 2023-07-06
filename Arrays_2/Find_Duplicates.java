package Arrays_2;

class Find_Duplicates{
    static int findDuplicate(int[] arr){
        int n = arr.length;
        int[] hash = new int[n+1];
        for(int i = 0 ; i < n ; i++){
            if(hash[arr[i]] == 0)
                hash[arr[i]]++;
            else 
             return arr[i];
        }        
        return 0;
    }

    
    public static void main(String[] args) {
       int[] arr  = {1,3,4,2,3};

       System.out.println("Duplicate elements " + findDuplicate(arr));
    }
}