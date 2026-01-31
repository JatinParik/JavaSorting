import java.util.Scanner;

public class BasicCountSort {

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

    static void countSort(int[] arr) {
        int max = findMax(arr);      //Find maximum element in array
        int[] count = new int[max+1];
        for(int i = 0; i<arr.length; i++) {
            count[arr[i]]++;       
        }
        int k = 0;
        for(int i = 0; i<count.length; i++) {
            for(int j = 0; j<count[i]; j++) {
                arr[k++] = i;
            }
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
        System.out.print("Sorted Array : ");
        printArray(arr);
    }
}
