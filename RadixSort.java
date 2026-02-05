import java.util.Scanner;

public class RadixSort {

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

    static void prefixSum(int[] arr) {
        if(arr.length==1) return;
        for(int i = 1; i<arr.length; i++) {
            arr[i] += arr[i-1];
        }
    }

    static void countSort(int[] arr, int place) {
        int[] count = new int[10];
        for(int i = 0; i<arr.length; i++) {   //Frequency Array
            int digit = (arr[i]/place)%10;
            count[digit]++;
        }
        prefixSum(count);
        int[] output = new int[arr.length];
        for(int i = arr.length-1; i>=0; i--) {  //Output array is sorted array for given place value
            int digit = (arr[i]/place)%10;
            int idx = count[digit]-1;
            output[idx] = arr[i];
            count[digit]--;
        }
        for(int i = 0; i<arr.length; i++) {  //Overwriting given arr
            arr[i] = output[i];
        }
    }

    static void radixSort(int[] arr) {
        int max = findMax(arr);
        for(int place = 1; max/place>0; place *= 10) {
            countSort(arr, place);
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
        radixSort(arr);
        System.out.print("Sorted Array : ");
        printArray(arr);
    }
}
