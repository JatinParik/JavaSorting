import java.util.Scanner;

public class BubbleSort {

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

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i<n-1; i++) {
            for(int j = 0; j<n-1-i; j++) {
                if(arr[j]>arr[j+1]) swap(arr, j, j+1);
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
        bubbleSort(arr);
        System.out.print("Sorted Array : ");
        printArray(arr);
    }
}