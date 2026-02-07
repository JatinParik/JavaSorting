import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    
    static void bubbleSort(ArrayList<Float> l) {
        for(int i = 0; i<l.size()-1; i++) {
            boolean flag = false;
            for(int j = 1; j<l.size()-i; j++) {
                if(l.get(j-1)>l.get(j)) {
                    float temp = l.get(j-1);
                    l.set(j-1, l.get(j));
                    l.set(j, temp);
                    flag = true;
                }
            }
            if(!flag) return;
        }
    }

    static void printArray(float[] arr) {
        for(float val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
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
            bubbleSort(buckets[i]);
            // Collections.sort(buckets[i]);    or can use directly sort method from collections library....Its Time complexity is O(nlogn)
        }
        int i = 0;
        for(int j = 0; j<buckets.length; j++) {
            for(int k = 0; k<buckets[j].size(); k++) {
                arr[i++] = buckets[j].get(k);
            }
        }
    }
    public static void main(String[] args) {
        float[] arr = {0.42f, 0.32f, 0.25f, 0.52f, 0.23f, 0.47f, 0.51f, 0.92f, 0.68f, 0.75f};
        System.out.print("Unsorted Array : ");
        printArray(arr);
        bucketSort(arr);
        System.out.print("Sorted Array : ");
        printArray(arr);
    }
}
