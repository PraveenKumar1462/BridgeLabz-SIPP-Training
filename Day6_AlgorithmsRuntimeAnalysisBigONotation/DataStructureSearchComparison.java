package Day6_AlgorithmsRuntimeAnalysisBigONotation;

import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int N = 1_000_000;
        int target = N / 2;
        int[] arr = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            arr[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        long start = System.nanoTime();
        boolean found = false;
        for (int i : arr) {
            if (i == target) {
                found = true;
                break;
            }
        }
        long end = System.nanoTime();
        System.out.println("Array search: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet search: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet search: " + (end - start) / 1_000_000.0 + " ms");
    }
}