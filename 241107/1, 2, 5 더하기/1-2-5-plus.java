import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr = {1, 2, 5};
    static int INT_MIN = Integer.MIN_VALUE;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        init();
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < arr.length; j++) {
                if(i >= arr[j]) {
                    dp[i] =  (dp[i] + dp[i - arr[j]]) % 10007;
                }
            }
        }

        System.out.println(dp[N]);
    }

    static void init() {
        dp[0] = 1;
        for(int i=1;i<=N;i++) {
            dp[i] = 0;
        }
    }
}