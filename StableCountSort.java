import java.util.Scanner;

public class StableCountSort {
    
    static void printArray(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static int findMax(int[] arr) { 
        if(arr.length==1) return arr[0];
        int max = arr[0];
        for(int i = 1; i<arr.length; i++) {
            if(max<arr[i]) max = arr[i];
        }
        return max;
    }
     
    static int[] frequencyArray(int[] arr, int max) {
         int[] f = new int[max+1];
         for(int i = 0; i<arr.length; i++) {
            f[arr[i]]++;
         }
         return f;
    }

    static void prefixSum(int[] arr) {
        if(arr.length==1) return;
        for(int i = 1; i<arr.length; i++) {
            arr[i] += arr[i-1];
        }
    }

    static void countSort(int[] arr) {
        int max = findMax(arr);
        int[] count = frequencyArray(arr, max);
        prefixSum(count);   //Elements of prefix sum of count array denotes the last position of number(given by the index) in sorted array
        int[] a = new int[arr.length];
        for(int i = arr.length-1; i>=0; i--) {
             a[count[arr[i]]-1] = arr[i];
             count[arr[i]]--;
        }
        for(int i = 0; i<arr.length; i++) {  //Overwriting the original array with the sorted array
            arr[i] = a[i];
        }
    }
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements of array : ");
        for(int i = 0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        countSort(arr);
        System.out.print("Sorted array : ");
        printArray(arr);
    }
}
