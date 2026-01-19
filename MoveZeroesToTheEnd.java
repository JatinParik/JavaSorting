import java.util.Scanner;

public class MoveZeroesToTheEnd {
    
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

    //First Approach
    static void zeroesAtEnd1(int[] arr) {
        if(arr.length==1) return;
        for(int i = 0; i<arr.length; i++) {
            if(arr[i]==0) {    //Selected index of 0
                int idx = i;
                for(int j = idx; j<arr.length-1; j++) {
                   swap(arr, j, j+1);    //Shifting zero element to the end by continuous swapping
                }
            }

        }
    }

    //Second Approach
    static void zeroesAtEnd2(int[] arr) {
        if(arr.length==1) return;
        for(int i = arr.length-2; i>=0; i--) {
            int j = i;
            while(j<arr.length-1 && arr[j]==0 && arr[j+1]!=0) {
               swap(arr, j+1, j);
               j++;
            }
        }
    }
    
    //Third Approach
    static void zeroesAtEnd3(int[] arr) {   //Approach similar to bubble sort algorithm
        boolean flag;
        for(int i = 0; i<arr.length-1; i++) {
            flag = false;
            for(int j = 0; j<arr.length-1-i; j++) {
                if(arr[j]==0 && arr[j+1]!=0) {
                    swap(arr, j+1, j);
                    flag = true;
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
        zeroesAtEnd3(arr);
        System.out.print("Array after moving zeroes at the end : ");
        printArray(arr);
    }
}
