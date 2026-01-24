import java.util.Scanner;

public class MergeSort {

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
    
    static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid-l+1;
        int n2 = r-mid;
        int[] a1 = new int[n1];    
        int[] a2 = new int[n2]; 
        //First sorted half
        for(int i = 0; i<n1; i++) {
            a1[i] = arr[l+i];
        }
        //Remaining sorted half
        for(int i = 0; i<n2; i++) {
            a2[i] = arr[mid+1+i];
        }
        int i = 0, j = 0, k = l;
        //Overall Sorted array
        while(i<n1 && j<n2) {     
            if(a1[i]<a2[j]) arr[k++] = a1[i++];
            else arr[k++] = a2[j++];
        }
        while(i<n1) arr[k++] = a1[i++];
        while(j<n2) arr[k++] = a2[j++];
    }

    static void mergeSort(int[] arr, int l, int r) {   //Sort arr from index l to r
        if(l==r) return;    //Base Case
        int mid = (l+r)/2;
        mergeSort(arr, l, mid);    //Sort half array
        mergeSort(arr, mid+1, r);   //Sort remaining half array
        merge(arr, l, mid, r);    //Merged two sorted arrays to form an overall sorted array
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
        mergeSort(arr, 0, arr.length-1);
        System.out.print("Sorted Array : ");
        printArray(arr);
    }
}
