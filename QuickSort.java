import java.util.Scanner;

public class QuickSort {
    
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

    static int partition(int[] arr, int st, int end) {
        int count = 0;
        for(int i = st+1; i<=end; i++) {
            if(arr[i]<arr[st]) count++;
        }
        int pI = st+count;
        swap(arr, st, pI);
        int i = st, j = st;
        while(i<pI && j<=end) {
           if(arr[j]<arr[pI]) swap(arr, i++, j++);  //Elements lesser than pivot stays on its left side
           else j++;
        }
        //Another Approach
        // int p = st, q = end;
        // while(p<pI && q>pI) {
        //     while(arr[p]<arr[pI]) p++;
        //     while(arr[q]>arr[pI]) q--;
        //     if(p<pI && q>pI) swap(arr, p++, q--);
        // }
        return pI;
    }

    static void quickSort(int[] arr, int st, int end) {   //Sorts array from index st to end
        if(st>=end) return;      // >= because if pivot index equals to start index then in recursion call of pI-1, it will be less than st
        int pI = partition(arr, st, end);
        quickSort(arr, st, pI-1);
        quickSort(arr, pI+1, end);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter elements of Array : ");
        for(int i = 0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, arr.length-1);
        System.out.print("Sorted Array : ");
        printArray(arr);
    }
}
