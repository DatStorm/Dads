import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by datstorm on 5/15/17.
 */
public class Week2HeapSort {

    public static void main(String args[]) {
        BinaryMaxHeap<String> heap = new BinaryMaxHeap<String>();
        heap.add(3, "Tushar");
        heap.add(4, "Ani");
        heap.add(8, "Vijay");
        heap.add(10, "Pramila");
        heap.add(5, "Roy");
        heap.add(6, "NTF");
        //heap.printHeap();


        // FIXME: Not working correctly.
        // should print : {6, 5, 3, 4, 2, 1}
        int[] test = {1, 2, 3, 4, 5, 6};
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.A = test;
        maxHeap.heapSize = test.length;
        HeapSort(maxHeap);
        print(maxHeap);
        HeapMaximum(maxHeap.A);
        maxHeapInsert(maxHeap,20);

        // should be 6.
        int largest = heapExtractMax(maxHeap);
        System.out.println("largest " + largest);
    }

    private static void maxHeapInsert(MaxHeap A, int key) {
        A.heapSize++;
        A.A[A.heapSize] = Integer.MIN_VALUE;
        heapIncreaseKey(A,A.heapSize,key);
    }

    private static void heapIncreaseKey(MaxHeap A, int i, int key) {
        if (key< A.A[i]){
            throw  new RuntimeException("new key is smaller then current key");
        }

        A.A[i] = key;
        while (i > 1 && A.A[Parent(i)]< A.A[i]){
            swap(A.A[i],A.A[Parent(i)],A.A);
            i = Parent(i);
        }
    }

    private static int Parent(int i) {
        if (i == 1) return 0;
        return (int) Math.floor(i/2);
    }

    private static int heapExtractMax(MaxHeap A) {
        if (A.heapSize < 1){
            throw  new RuntimeException("heap underflow");
        }
        int max = A.A[0];
        A.A[0] = A.A[A.heapSize];
        A.heapSize = A.heapSize-1;
        MaxHeapify(A,0);
        return max;
    }

    private static int HeapMaximum(int[] A) {
        return A[0];
    }

    private static void print(MaxHeap A) {
        for (int i : A.A) {
            System.out.println(i + " ");
        }

    }

    static class MaxHeap {
        int[] A;
        int heapSize;
    }

    private static void HeapSort(MaxHeap A) {
        BuildMaxHeap(A);
        for (int i = A.A.length; i >= 2; i--) {
            swap(1, i, A.A);
            A.heapSize = A.heapSize - 1;
            MaxHeapify(A, 1);
        }

    }

    private static void BuildMaxHeap(MaxHeap A) {
        A.heapSize = A.A.length;
        for (int i = (int) Math.floor(A.A.length / 2); i == 1; i--) {
            MaxHeapify(A, i);
        }
    }


    public static void MaxHeapify(MaxHeap A, int i) {
        int l = A.A[LEFT(A, i)];
        int r = A.A[RIGHT(A, i)];
        int largest = 0;
        if (l <= A.heapSize && A.A[l] > A.A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= A.heapSize && A.A[r] > A.A[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(A.A[i], A.A[largest], A.A);
            MaxHeapify(A, largest);
        }
    }

    // FIXME!!!! GOING WRONG
    private static void exchange(int one, int two, MaxHeap A) {
        one = one - 1;
        two = two - 1;
        int temporyOne = A.A[one];
        int temporyTwo = A.A[two];
//        for (int i : A.A) {
//            System.out.printf(i + " ");
//        }
        A.A[one] = temporyTwo;
        A.A[two] = temporyOne;
//        for (int i : A.A) {
//            System.out.printf(i + " ");
//        }
//        System.out.println();
    }

    public static final <T> void swap(List<T> l, int i, int j) {
        Collections.<T>swap(l, i, j);
    }

    public static final <T> void swap(int i, int j, int[] a) {
        i = i-1;
        j = j-1;
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    private static int RIGHT(MaxHeap A, int i) {
        if (2 * i + 1 <= A.heapSize) {
            return 2 * i + 1;
        }
        return 0;
    }


    private static int LEFT(MaxHeap A, int i) {
        if (2 * i <= A.heapSize) {
            return 2 * i;
        }
        return 0;
    }

    /**
     * FROM ALGORITHEM MASTER
     *
     * @param <T>
     */
    public static class BinaryMaxHeap<T> {

        private List<Node> allNodes = new ArrayList<Node>();

        class Node {
            int weight;
            T data;
        }

        public void add(int weight, T data) {

            Node node = new Node();
            node.weight = weight;
            node.data = data;
            allNodes.add(node);
            int size = allNodes.size();
            int current = size - 1;
            int parentIndex = (current - 1) / 2;

            while (parentIndex >= 0) {
                Node parentNode = allNodes.get(parentIndex);
                Node currentNode = allNodes.get(current);
                if (parentNode.weight < currentNode.weight) {
                    swap(parentNode, currentNode);
                    current = parentIndex;
                    parentIndex = (parentIndex - 1) / 2;
                } else {
                    break;
                }
            }

        }

        private void swap(Node node1, Node node2) {
            int weight = node1.weight;
            T data = node1.data;

            node1.data = node2.data;
            node1.weight = node2.weight;

            node2.data = data;
            node2.weight = weight;
        }

        public T max() {
            return allNodes.get(0).data;
        }

        public boolean empty() {
            return allNodes.size() == 0;
        }


        public T extractMap() {
            int size = allNodes.size() - 1;
            T max = allNodes.get(0).data;
            int lastNodeWeight = allNodes.get(size).weight;
            allNodes.get(0).weight = lastNodeWeight;
            allNodes.get(0).data = allNodes.get(size).data;
            allNodes.remove(size);

            int currentIndex = 0;
            size--;
            while (true) {
                int left = 2 * currentIndex + 1;
                int right = 2 * currentIndex + 2;
                if (left > size) {
                    break;
                }
                if (right > size) {
                    right = left;
                }
                int largerIndex = allNodes.get(left).weight >= allNodes.get(right).weight ? left : right;
                if (allNodes.get(currentIndex).weight < allNodes.get(largerIndex).weight) {
                    swap(allNodes.get(currentIndex), allNodes.get(largerIndex));
                    currentIndex = largerIndex;
                } else {
                    break;
                }
            }
            return max;
        }

        public void printHeap() {
            for (Node n : allNodes) {
                System.out.println(n.weight + " " + n.data);
            }
        }


    }
}
