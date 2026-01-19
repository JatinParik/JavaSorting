import java.util.Scanner;

public class LexicographicalOrder { //Sorting using selection sort algorithm
    
    static void printArray(String[] arr) {
        for(String s : arr) {
            System.out.print(s + "  ");
        }
    }

    static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int minIndex(String[] arr, int i1, int i2) {
       int l1 = arr[i1].length();
       int l2 = arr[i2].length();
       int m = Math.min(l1,l2); 
       for(int i = 0; i<m; i++) {
        if(arr[i1].charAt(i)==arr[i2].charAt(i)) continue;
        if(arr[i1].charAt(i)<arr[i2].charAt(i)) return i1;
        else return i2;
       }
       if(m==l1) return i1;
       else return i2;
    }

    static void lexoOrder(String[] arr) {   
        for(int i = 0; i<arr.length-1; i++) {
            int minIdx = i;
            for(int j = i+1; j<arr.length; j++) {
                minIdx = minIndex(arr, j, minIdx);
            }
            swap(arr, i, minIdx);
        }
    }

    //Another appraoch : Directly using compareTo() method
    static void lexoOrder2(String[] arr) {
        int num;
        for(int i = 0; i<arr.length-1; i++) {
            int minIdx = i; 
            for(int j = i+1; j<arr.length; j++) {
               num = arr[minIdx].compareTo(arr[j]);  
               if(num>0) minIdx = j;
            }
            swap(arr, i, minIdx);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of Array : ");
        int n = sc.nextInt();
        String[] arr = new String[n];
        System.out.print("Enter elements : ");
        for(int i = 0; i<arr.length; i++) {
            arr[i] = sc.next();
        }
        lexoOrder2(arr);
        System.out.print("Lexographical Order for given Strings : ");
        printArray(arr);
    }
}
