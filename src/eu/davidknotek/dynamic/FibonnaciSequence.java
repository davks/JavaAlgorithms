package eu.davidknotek.dynamic;

public class FibonnaciSequence {
    public static long counter = 0;
    public static long counterMemo = 0;
    public static long counterMemo2 = 0;

    static Long[] memo = new Long[1000];

    public static long fib(int n) {
        counter++;

        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static long fibMemo(int n) {
        counterMemo++;

        if (memo[n] != null) {
            return memo[n];
        }

        if (n == 0 || n == 1) {
            return n;
        }
        memo[n] = fibMemo(n - 1) + fibMemo(n - 2);
        return memo[n];
    }

    public static long fibMemo2(int n) {
        long [] fibList = new long [n+1];
        fibList[0] = 0;
        fibList[1] = 1;

        for (int index = 2; index <= n; index++) {
            counterMemo2++;
            fibList[index] = fibList[index-1] + fibList[index-2];
        }

        return fibList[n];
    }
}
