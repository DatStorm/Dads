import java.util.Collections;

/**
 * Created by datstorm on 5/8/17.
 */
public class Week1InsertionSort {

    // worst case n^2
    // best case n
    // average n^2
    public static void main(String[] args) {

    }
    public void insertionSort(int[] A){
        int key = 0;
        for (int j = 2; j < A.length; j++) {
            key = A[j];

            // insert A[j] into the sorted sequence A[1 .. j-1]
            int i = j-1;

            while (i>0 && A[i] > key){
                A[i+1] = A[i];

                i = i -1;
            }
            A[i+1] = key;
        }
    }
}
