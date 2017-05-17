/**
 * Created by datstorm on 5/16/17.
 */
public class Week2QuickSort {
    public static void main(String args[]) {
        QuickSort qs = new QuickSort();
        int A[] = {11, 19, 0, -1, 5, 6, 16, -3, 6, 0, 14, 18, 7, 21, 18, -6, -8};
//      int A[] = {11,9,0,4,6,-1,13};
        qs.sort(A, 0, A.length - 1);
        //qs.printArray(A);

        int B[] = {2,5,1,4,3,6};
        int p = 1;
        int r = 5;
        quickSort(B, p, r);
        print(B);

    }

    private static void print(int[] B) {
        for (int i : B) {
            System.out.println(i + " ");
        }

    }

    private static void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = PARTITION(A, p, r);
            quickSort(A,p,q-1);
            quickSort(A,q+1,r);
        }
    }

    private static int PARTITION(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r - 1; j++) {
            if (A[j] <= x) {
                i++;
                swap(A[i], A[j], A);
            }
        }
        swap(A[i + 1], A[r], A);
        return i + 1;
    }

    public static final <T> void swap(int i, int j, int[] a) {
        i = i - 1;
        j = j - 1;
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    /**
     * From Algorithems-Master
     */
    public static class QuickSort {

        private void swap(int A[], int i, int j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

        private int split(int A[], int low, int high) {
            int pivot = low;
            int i = low + 1;
            int j = high;
            while (i < j) {
                while (i <= j && A[pivot] >= A[i]) {
                    i++;
                }
                while (j >= i && A[pivot] < A[j]) {
                    j--;
                }
                if (i < j && A[i] > A[j]) {
                    swap(A, i++, j--);
                }
            }
            if (A[pivot] > A[j]) {
                swap(A, j, pivot);
            }
            return j;
        }

        private int split1(int A[], int low, int high) {

            int pivot = low;
            int i = low + 1;
            int j = high;
            while (i <= j) {

                if (A[i] <= A[pivot]) {
                    i++;
                    continue;
                }
                if (A[j] > A[pivot]) {
                    j--;
                    continue;
                }
                swap(A, i++, j--);
            }
            if (A[pivot] > A[j]) {
                swap(A, pivot, j);
                return j;
            }
            return pivot;

        }

        public void sort(int A[], int low, int high) {
            if (low >= high) {
                return;
            }
            int pos = split1(A, low, high);
            sort(A, low, pos - 1);
            sort(A, pos + 1, high);
        }

        private void printArray(int arr[]) {
            for (int a : arr) {
                System.out.println(a);
            }
        }

    }


}
