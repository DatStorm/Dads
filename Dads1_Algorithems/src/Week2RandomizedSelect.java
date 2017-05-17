/**
 * Created by datstorm on 5/16/17.
 */
public class Week2RandomizedSelect {


    public static void main(String[] args) {
        int p = 1;
        int r = 0;
        int i = 0;
        int A[] = {1, 2, 3, 4, 5, 6};
        System.out.println(randomizedSelect(A, p, r, i));
    }

    private static int randomizedSelect(int[] A, int p, int r, int i) {

        if (p == r)
            return A[p];
        int q = randomizedPartition(A, p, r);
        int k = q - p + 1;

        if (i == k)
            return A[q];
        else if (i < k)
            return randomizedSelect(A, p, q - 1, i);
        else return randomizedSelect(A, q + 1, r, i - k);
    }


    private static int randomizedPartition(int[] A, int p, int r) {
        return 0;

    }
}
