package Day2_StacksQueuesHashMapsHashFunctions;

import java.util.LinkedList;
import java.util.Queue;

public class CircularTourProblem {
    public static int findStartingPump(int[] petrol, int[] distance) {
        int n = petrol.length;
        int start = 0, end = 1;
        int currPetrol = petrol[start] - distance[start];

        while (end != start || currPetrol < 0) {
            while (currPetrol < 0 && start != end) {
                currPetrol -= petrol[start] - distance[start];
                start = (start + 1) % n;
                if (start == 0) {
                    return -1;
                }
            }
            currPetrol += petrol[end] - distance[end];
            end = (end + 1) % n;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] petrol = {6, 3, 7};
        int[] distance = {4, 6, 3};
        int start = findStartingPump(petrol, distance);
        System.out.println(start);
    }
}
