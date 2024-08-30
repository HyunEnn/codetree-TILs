import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] dp;
    static int[] coins;
    static int INT_MAX = Integer.MAX_VALUE;
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
                    if(dp[i-coins[j]] == INT_MAX)
                        continue;
//                    System.out.println("dp 이전 값 : " + dp[i-coins[j]]);
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }

        if(dp[M] == INT_MAX)
            System.out.println(-1);
        else
            System.out.println(dp[M]);
    }

    static void init() {
        dp[0] = 0;
        for(int i=1;i<=M;i++) {
            dp[i] = INT_MAX;
        }
    }
}