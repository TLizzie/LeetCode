package LeetCode.DynamicProgramming;

public class FibonacciNumber {

    public int fibnacciNumber(int N) {
        if (N <= 1) {
            return N;
        } else {
            return fibnacciNumber(N - 1) + fibnacciNumber(N - 2);
        }
    }



    // 开辟数组的最大空间
    // from top to bottom
    public int[] memorization = new int[15464691];
    public int fibNacciNumber2(int N) {
        if (N <= 1) {
            return N;
        }
        if (memorization[N] == 0) {
            memorization[N] = memorization[N - 1] + memorization[N - 2];
        }
        return memorization[N];
    }

    //from bottom to top
    public int fib3(int N) {
        if (N <= 1) {
            return N;
        }

        int[] dp = new int[N + 1];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }


    //space: O(1)
    public int fib4(int N) {
        if (N <= 1) {
            return N;
        }
        int a = 0;
        int b = 1;
        while(N-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
