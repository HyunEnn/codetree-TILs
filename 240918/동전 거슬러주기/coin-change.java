import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] dp;
    static int INT_MAX = Integer.MAX_VALUE;
    static int[] coins;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        coins = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        } 

        initDP();
        for(int i=1;i<=M;i++) {
            for(int j=0;j<N;j++) {
                if(i >= coins[j]) {
                    if(dp[i - coins[j]] == INT_MAX) 
                        continue;
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }
        
        if(dp[M] != INT_MAX)
            System.out.println(dp[M]);
        else
            System.out.println(-1);
    }

    public static void initDP() {
        dp = new int[M+1];
        for(int i=1;i<=M;i++) {
            dp[i] = INT_MAX;
        }
    }
}