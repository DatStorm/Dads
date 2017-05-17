/**
 * Created by datstorm on 5/8/17.
 */
public class Week2MergeSort {

            public static void main(String args[]){
            int input1[] = {1};
            int input2[] = {4,2};
            int input3[] = {6,2,9};
            int input4[] = {6,-1,10,4,11,14,19,12,18};
            MergeSort ms = new MergeSort();
            ms.sort(input1);
            ms.sort(input2);
            ms.sort(input3);
            ms.sort(input4);

            ms.printArray(input1);
            ms.printArray(input2);
            ms.printArray(input3);
            ms.printArray(input4);
        }


    public static void MergeSort(int[] A, int p, int r){


        if (p< r){
            int q = (p+r)/2;
            MergeSort(A,p,q);
            MergeSort(A,q+1,r);
            Merge(A,p,q,r);
        }
    }

    private static void Merge(int[] A, int p, int q, int r) {
        int n1 = q-p+1;
        int n2 = r-q;

        int[] L = new int[n1+1];
        int[] R = new int[n2+1];



    }

    // FROM MASTER
    static class MergeSort {

        public void sort(int input[]){
            sort(input, 0, input.length-1);
        }

        private void sort(int input[], int low, int high){
            if(low >= high){
                return;
            }

            int middle = (low + high)/2;
            sort(input, low, middle);
            sort(input, middle+1, high);
            sortedMerge(input,low,high);
        }

        private void sortedMerge(int input[], int low, int high){
            int middle = (low+high)/2;
            int temp[] = new int[high-low+1];
            int i = low;
            int j = middle+1;
            int r = 0;
            while(i <= middle && j <= high){
                if(input[i] <= input[j]){
                    temp[r++] = input[i++];
                }else{
                    temp[r++] = input[j++];
                }
            }
            while(i <= middle){
                temp[r++] = input[i++];
            }

            while(j <= high){
                temp[r++] = input[j++];
            }
            i = low;
            for(int k=0; k < temp.length;){
                input[i++] = temp[k++];
            }
        }

        public void printArray(int input[]){
            for(int i : input){
                System.out.print(i + " ");
            }
            System.out.println();
        }


    }
}
