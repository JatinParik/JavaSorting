public class SortAnArrayContainsOnlyZeroOneAndTwo {
    
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

    static void sort012(int[] arr) {
        int[] count = new int[3];
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

    //Another Approach
    static void sort012_A(int[] arr) {
        int i = 0, j = 0, num = 0;
        for(int k = 0; k<2; k++) {
            j = i;
            while(j<arr.length) {
              if(arr[j]==num) swap(arr, i++, j++);
              else j++;
            } num++;
        }
    }

    //Another Approach
    static void sort012_B(int[] arr) {
        int low = 0, mid = 0, high = arr.length-1;
        while(mid<=high) {
        if(arr[mid]==0) swap(arr, mid++, low++);
        else if(arr[mid]==1) mid++;
        else swap(arr, mid, high--);
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 2, 2, 1, 1, 0, 1, 1, 0, 0};
        System.out.print("Unsorted Array : ");
        printArray(arr);
        System.out.print("Sorted Array : ");
        sort012_B(arr);
        printArray(arr);
    }
}
