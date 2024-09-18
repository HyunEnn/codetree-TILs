import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] coins;
    static int INT_MIN = Integer.MIN_VALUE;
    static int[] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        coins = new int[N];
        dp = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        initDP();
        for(int i=1;i<=M;i++) {
            for(int j=0;j<N;j++) {
                if(i >= coins[j]) {
                    if(dp[i - coins[j]] == INT_MIN) continue;
                    dp[i] = Math.max(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }

        if(dp[M] != INT_MIN) {
            System.out.println(dp[M]);
        } else {
            System.out.println(-1);
        }

    }

    public static void initDP() {
        for(int i=1;i<=M;i++) {
            dp[i] = INT_MIN;
        }
    }
}