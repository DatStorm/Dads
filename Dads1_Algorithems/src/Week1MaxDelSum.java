import static java.lang.Integer.max;

/**
 * Created by datstorm on 5/8/17.
 */
public class Week1MaxDelSum {

    // n^3
    public static void algorithem1(int[] x, int n) {
        int maxSoFar = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;

                for (int k = i; k < j; k++) {
                    sum += x[k];
                }
                maxSoFar = max(maxSoFar, sum);
            }
        }
    }

    // n^2
    public static void algorithem2(int[] x, int n) {
        int maxSoFar = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += x[j];
                maxSoFar = max(maxSoFar, sum);
            }
        }
    }


    public static void algorithem3(int[] x, int n) {
        int answer = maxSum3(0,n-1, x);

    }
    // O(n * log n)
    private static int maxSum3(int l, int u, int[] x) {
        if (l>u)
            return 0;
        if (l==u)
            return max(0,x[l]);
        int m = (l+u)/2;
        int lmax = 0, sum = 0;

        for (int i = m; i >= 1; i--) {
            sum += x[i];
            lmax = max(lmax,sum);
        }

        int rmax = 0;
        for (int i = m; i < u; i++) {
            sum += x[i];
            rmax = max(rmax,sum);
        }

        return max2(lmax+rmax,maxSum3(l,m,x),maxSum3(m+1,u,x));
    }

    private static int max2(int one, int two, int three) {
        if (one> two)
            if (one > three)
                return one;
        else if (two > one)
            if (two > three)
                return two;
        else if (three> one)
            if (three> two)
                return three;

        return -1;
    }

    // n
    public static void algorithem4(int[] x, int n) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for (int i = 0; i < n; i++) {

            maxEndingHere = max(maxEndingHere+ x[i],0);
            maxSoFar = max(maxSoFar, maxEndingHere);

        }
    }


}
