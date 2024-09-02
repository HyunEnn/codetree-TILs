import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int INT_MIN = Integer.MIN_VALUE;
    static int[] coins;
    static int[] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        coins = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[M+1];
        init();
        for(int i=1;i<=M;i++) {
            for(int j=0;j<coins.length;j++) {
                if(i >= coins[j]) {
                    if(dp[i-coins[j]] == INT_MIN)
                        continue;
                    dp[i] = Math.max(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }

        System.out.println(dp[M]);
    }

    static void init() {
        for(int i=1;i<=M;i++) {
            dp[i] = INT_MIN;
        }
        dp[0] = 0;
    }
}