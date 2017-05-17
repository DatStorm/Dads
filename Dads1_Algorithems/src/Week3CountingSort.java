/**
 * Created by datstorm on 5/16/17.
 */
public class Week3CountingSort {


    public static void main(String[] args) {

        int A[] = {1, 2, 3, 4, 5, 6};
        int B[] = new int[A.length];

        int k = 0;
        countingSort(A, B, k);
    }

    private static void countingSort(int[] A, int[] B, int k) {

        int C[] = new int[k];


        for (int i = 0; i < k; i++) {
            C[i] = 0;
        }

        for (int j = 1; j < A.length; j++) {
            C[A[j]] = C[A[j]] + 1;
        }

        for (int i = 1; i < k; i++) {
            C[i] = C[i] + C[i - 1];
        }

        for (int j = A.length; j >= 1; j--) {
            B[C[A[j]]] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }
    }


}
