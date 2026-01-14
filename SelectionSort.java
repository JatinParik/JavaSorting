import java.util.Scanner;

public class SelectionSort {
    
    static void swap(int[] arr, int i, int j) {
    int t = arr[i];
    arr[i] = arr[j];
    arr[j] = t;
    }

    static void printArray(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void selectionSort(int[] arr) {
        int minIdx;
        for(int i = 0; i<arr.length-1; i++) {    //Sort elements from index i to the end index
            minIdx = i; 
            for(int j = i+1; j<arr.length; j++) {
                if(arr[j]<arr[minIdx]) minIdx=j;   //Finding the index of minimum element
            }
            if(minIdx != i) {
            swap(arr, minIdx, i);   //Swapping the minimum element with the first element of subarray under processing 
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements of the Array : ");
        for(int i = 0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        selectionSort(arr);
        System.out.print("Sorted Array : ");
        printArray(arr);
    }
}
