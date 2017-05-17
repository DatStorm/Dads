/**
 * Created by datstorm on 5/16/17.
 */
public class Week3InsertionSort {


    public static void main(String[] args) {

        int A[] = {1, 2, 3, 4, 5, 6};
        insertionSort(A);
    }

    private static void insertionSort(int[] A) {
        for (int j = 2; j < A.length; j++) {
            int key = A[j];

            int i = j - 1;

            while (i > 0 && A[i] > key) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }
    }
}
