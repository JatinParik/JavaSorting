public class TwoSwappedElementsInASortedArray {
    
    static void printArray(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        } System.out.println();
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static void fixSwap(int[] arr) {
        if(arr.length<=1) return;     //handling corner or edge cases
        int i = 0, j = arr.length-1;
        while(arr[i]<arr[i+1]) {
            i++;
        }
        while(arr[j]>arr[j-1]) {
            j--;
        }
        swap(arr, i, j);
    }

    //Another Approach
    static void fixSwap2(int[] arr) {
        if(arr.length<=1) return;    //handling corner or edge cases
        int x = -1, y = -1;
        for(int i = 1; i<arr.length; i++) {
            if(arr[i-1]>arr[i]) {
            if(x==-1) {  //first conflict
                x = i-1;
                y = i;     //if size of array is 2 then this will handle the error
            } else  y = i;  //second conflict
            }
        } swap(arr, x, y);
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 7, 5, 9, 10};      //No duplicate elements are present in the array 
        System.out.print("Unsorted Array : ");
        printArray(arr);
        System.out.print("Sorted Array : ");
        fixSwap(arr);
        printArray(arr);
    }
}
