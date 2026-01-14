import java.util.Scanner;

public class OptimisedBubbleSort {

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
        boolean flag;    //Check Swapping
        for(int i = 0; i<n-1; i++) {
            flag = false;  
            for(int j = 0; j<n-1-i; j++) {
                if(arr[j]>arr[j+1]) {
                    swap(arr, j, j+1);
                    flag = true;   //Swapping Occurs
                }
            }
            if(!flag) return;
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
