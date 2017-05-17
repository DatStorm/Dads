/**
 * Created by datstorm on 5/16/17.
 */
public class Week3Stack {


    public static void main(String[] args) {

        Stak s = new Stak();
        stackEmpty(s);
        int x = 0;
        push(s, x);
        Pop(s);
    }

    private static int Pop(Stak S) {
        if (stackEmpty(S))
            throw new RuntimeException("underflow");
        else
            S.top = S.top -1;
        return S.A[S.top+1];
    }

    private static void push(Stak S, int x) {
        S.top = S.top + 1;
        S.A[S.top] = x;

    }

    private static boolean stackEmpty(Stak S) {
        if (S.top == 0)
            return true;
        else
            return false;
    }

    static class Stak {
        int top;
        int[] A;
    }


}
