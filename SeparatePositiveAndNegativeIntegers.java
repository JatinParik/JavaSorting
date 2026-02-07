public class SeparatePositiveAndNegativeIntegers {

    static void printArray(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        } System.out.println();
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static void separate(int[] arr) {
          int i = 0, j = arr.length-1;
          while(i<j) {
            if(arr[i]>0 && arr[j]<0) swap(arr, i++, j--);
            if(arr[i]<0) i++;
            if(arr[j]>0) j--;
          }
    }

    //Another Approach
    static void separate2(int[] arr) {
          int i = 0, j = arr.length-1;
          while(i<j) {
            while(arr[i]<0) i++;
            while(arr[j]>=0) j--;
            if(i<j) swap(arr, i, j);
          }
    }
    public static void main(String[] args) {
        int[] arr = {19, -20, 7, -4, -13, 11, -5, 3};
        System.out.print("Initial Array : ");
        printArray(arr);
        System.out.print("Array after separation : ");
        separate(arr);
        printArray(arr);
    }
}