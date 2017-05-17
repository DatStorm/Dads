/**
 * Created by datstorm on 5/16/17.
 */
public class Week3DoubleChainedList {

    public static void main(String[] args) {

        int k = 0;
        List list = new List();
        listSearch(list,k);
        int x = 0;
        listInsert(list,x);

        listDelete(list,list.node);
    }

    private static void listDelete(List L, Node x) {
        if (x.prev.NIL != L.node.NIL){
            x.prev.next = x.next;
        }else
            L.node.head = x.next;
        if (x.next.NIL != L.node.NIL){
            x.next.prev = x.prev;
        }
    }

    private static void listInsert(List L, int x) {
        Node x2 = Node.newNode(x);
        x2.next = L.node.head;

        if (L.node.head.NIL != L.NIL){
            L.node.head.prev = x2;
        }
        L.node.head = x2;
        // Should be NIL
        x2.prev = null;

    }


    private static Node listSearch(List L, int k) {

        Node x = L.node.head;
        while (x.NIL != L.NIL && x.key != k){
            x = x.next;
        }
        return x;
    }

    static class Node{
        Node next;
        Node prev;
        Node child;
        Object data;
        Object obj;
        Node head;
        int key;
        boolean NIL;
        public static Node newNode(Object data, Object... obj){
            Node n = new Node();
            n.data = data;
            n.next = null;
            n.prev = null;
            if (obj.length >0){
                n.obj = obj[0];
            }
            return n;
        }
    }
    static class List{

        boolean NIL;
        Node node;

        public Node addNode(int data, Node head, Object... obj){
            Node temp = head;
            Node n = null;
            if(obj.length > 0){
                n = Node.newNode(data, obj[0]);
            }else{
                n = Node.newNode(data);
            }
            if(head == null){
                return n;
            }

            while(head.next != null){
                head = head.next;
            }

            head.next = n;
            return temp;
        }





    }


}
