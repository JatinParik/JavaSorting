import java.util.Scanner;

public class InsertionSort {
    
    static void printArray(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static void insertionSort(int[] arr) {
        if(arr.length==1) return;
        int idx;
        for(int i = 1; i<arr.length; i++) {
           idx = i;
           while(idx>0 && arr[idx]<arr[idx-1]) {
            swap(arr, idx, idx-1);
            idx--;
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
        insertionSort(arr);
        System.out.print("Sorted Array : ");
        printArray(arr);
    }
}
