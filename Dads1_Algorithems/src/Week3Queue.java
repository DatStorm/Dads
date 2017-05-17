/**
 * Created by datstorm on 5/16/17.
 */
public class Week3Queue {

    public static void main(String[] args) {

        Queue q = new Queue();
        int x = 0;
        enqueue(q,x);
        dequeue(q);
    }

    private static int dequeue(Queue Q) {
        int x = Q.A[Q.head];
        if (Q.head == Q.length)
            Q.head = 1;
        else
            Q.head ++;
        return x;
    }

    private static void enqueue(Queue Q, int x) {
        Q.A[Q.tail] = x;
        if (Q.tail == Q.length)
            Q.tail = 1;
        else
            Q.tail = Q.tail +1;
    }


    static class Queue{
        int head;
        int length;
        int tail;
        int[] A;
    }


}
