package Day4and5_LinearAndBinarySearch;

public class BinarySearchFirstLastOccurrence {
    public static int[] findFirstLast(int[] arr, int target) {
        int first = -1, last = -1;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        left = 0; right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return new int[]{first, last};
    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 8, 10};
        int[] res = findFirstLast(arr, 4);
        System.out.println("First: " + res[0] + ", Last: " + res[1]);
    }
}