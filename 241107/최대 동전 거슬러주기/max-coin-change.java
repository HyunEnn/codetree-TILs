import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] coins;
    static int[] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        coins = new int[N+1];
        dp = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        initDP();
        for(int i=1;i<=M;i++) {
            for(int j=0;j<coins.length;j++) {
                if(i >= coins[j]) {
                    if(dp[i-coins[j]] == Integer.MIN_VALUE)
                        continue;
                    dp[i] = Math.max(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }

        System.out.println(dp[M]);
    }

    public static void initDP() {
        for(int i=0;i<=M;i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 0;
    }
}