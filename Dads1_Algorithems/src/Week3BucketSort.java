import java.util.LinkedList;

/**
 * Created by datstorm on 5/16/17.
 */
public class Week3BucketSort {


    public static void main(String[] args) {
        int A[] = {1,2,3,4,5,6};

        buketSort(A, A.length);
    }

    private static void buketSort(int[] A, int n) {
        int B[] = new int[n-1];

        for (int i = 0; i < n - 1; i++) {
            B[i] = 0;
        }
        for (int i = 1; i < n; i++) {
            B[i]= A[i];
        }

        for (int i = 0; i < n - 1; i++) {
             new Week1InsertionSort().insertionSort(B);
        }
    }
}
