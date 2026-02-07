import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Practice {

    static void printIntArray(int[] arr) {
        for(int val : arr) {
            System.out.print(val + " ");
        } System.out.println();
    }

    static void printFloatArray(float[] arr) {
        for(float val : arr) {
            System.out.print(val + " ");
        } System.out.println();
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static int maxValue(int[] arr) {
        int max = arr[0];
        for(int i = 1; i<arr.length; i++) {
            if(arr[i]>max) max = arr[i];
        }
        return max;
    }

    static void prefixSum(int[] arr) {
        for(int i = 1; i<arr.length; i++) {
            arr[i] += arr[i-1];
        }
    }

    static void bubbleSort(int[] arr) {
        boolean flag;
        for(int i = 0; i<arr.length-1; i++) {
            flag = false;
            for(int j = 0; j<arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]) {
                  swap(arr, j+1, j);
                  flag = true;
                }
            }
            if(!flag) return;
        }
    }

    static void selectionSort(int[] arr) {
        for(int i = 0; i<arr.length; i++) {
            int minIdx = i;
            for(int j = i+1; j<arr.length; j++) {
                if(arr[j]<arr[minIdx]) minIdx = j; 
            }
            swap(arr, i, minIdx);
        }
    }

    static void insertionSort(int[] arr) {
        for(int i = 1; i<arr.length; i++) {
            for(int j = i; j>0; j--) {
                if(arr[j]<arr[j-1]) swap(arr, j-1, j);
                else break;
            }
        }
    }

    static void merge(int[] arr, int st, int mid, int end) {
         int n1 = mid-st+1;
         int n2 = end-mid;
         int[] a1 = new int[n1];
         int[] a2 = new int[n2];
         for(int i = 0; i<a1.length; i++) {
            a1[i] = arr[st+i];
         }
         for(int i = 0; i<a2.length; i++) {
            a2[i] = arr[mid+1+i];
         }
         int i = 0, j = 0, k = st;
         while(i<a1.length && j<a2.length) {
            if(a1[i]<a2[j]) arr[k++] = a1[i++];
            else arr[k++] = a2[j++];
         } 
         while(i<a1.length) arr[k++] = a1[i++];
         while(j<a2.length) arr[k++] = a2[j++];
    }

    static void mergeSort(int[] arr, int st, int end) {
        if(st>=end) return;
        int mid = (st+end)/2;
        mergeSort(arr, st, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, st, mid, end);
    }

    static int partition(int[] arr, int l, int r) {
        int randomIdx = ThreadLocalRandom.current().nextInt(l,r+1);
        int pivot = arr[randomIdx];
        int count = 0;
        for(int i = l; i<=r; i++) {
            if(arr[i]<pivot) count++; 
        }
        int pivotIdx = l+count;
        swap(arr, randomIdx, pivotIdx);
        int i = l, j = r;
        while(i<pivotIdx && j>pivotIdx) {
            while(arr[i]<pivot) i++;
            while(arr[j]>pivot) j--;
            if(i<pivotIdx && j>pivotIdx) swap(arr, i++, j--);
        }
        return pivotIdx;
    }

    static void quickSort(int[] arr, int l, int r) {
        if(l>=r) return;
        int pivotIdx = partition(arr, l, r);
        quickSort(arr, l, pivotIdx-1);
        quickSort(arr, pivotIdx+1, r);
    }

    static void countSort(int[] arr) {
        int max = maxValue(arr);
        int[] count = new int[max+1];
        for(int i = 0; i<arr.length; i++) {
            count[arr[i]]++;
        }
        prefixSum(count);
        int[] output = new int[arr.length];
        for(int i = arr.length-1; i>=0; i--) {
            int idx = count[arr[i]]-1;
            output[idx] = arr[i];
            count[arr[i]]--;
        }
        for(int i = 0; i<arr.length; i++) {
            arr[i] = output[i];
        }
    }

    static void countSortForRadixSort(int[] arr, int place) {
        int[] count = new int[10];
        for(int i = 0; i<arr.length; i++) {
            int digit = (arr[i]/place)%10;
            count[digit]++;
        }
        prefixSum(count);
        int[] output = new int[arr.length];
        for(int i = arr.length-1; i>=0; i--) {
            int digit = (arr[i]/place)%10;
            int idx = count[digit]-1;
            output[idx] = arr[i];
            count[digit]--;
        }
        for(int i = 0; i<arr.length; i++) {
            arr[i] = output[i];
        }
    }

    static void radixSort(int[] arr) {
        int max = maxValue(arr);
        for(int place = 1; max/place>0; place *= 10) {
            countSortForRadixSort(arr, place);
        }
    }

    static void bucketSort(float[] arr) {
       ArrayList<Float>[] buckets = new ArrayList[10];
       for(int i = 0; i<buckets.length; i++) {
        buckets[i] = new ArrayList<>();
       }
       for(int i = 0; i<arr.length; i++) {
        int idx = (int)(arr[i]*10);
        buckets[idx].add(arr[i]);
       }
       for(int i = 0; i<buckets.length; i++) {
        Collections.sort(buckets[i]);
       }
       int k = 0;
       for(int i = 0; i<buckets.length; i++) {
        for(int j = 0; j<buckets[i].size(); j++) {
            arr[k++] = buckets[i].get(j);
        }
       }
    }
    public static void main(String[] args) {
        int[] arr = {149,331,126,434,224,546,982,712};
        float[] a = {0.3f,0.2f,0.7f,0.1f,0.8f,0.4f,0.6f,0.3f};
        System.out.print("Unsorted Array : ");
        printFloatArray(a);
        System.out.print("Sorted Array : ");
        bucketSort(a);;
        printFloatArray(a);
        System.out.print("Unsorted Array : ");
        printIntArray(arr);
        System.out.print("Sorted Array : ");
        radixSort(arr);;
        printIntArray(arr);
    }
}