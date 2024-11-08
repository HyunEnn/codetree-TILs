import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] sticks;
    static int[][] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sticks = new int[N+1];
        dp = new int[N+1][N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            sticks[i] = Integer.parseInt(st.nextToken());
        }

        initDp();
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(j >= i) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-i] + sticks[i]);
                } else
                    dp[i][j] = dp[i-1][j];
            }
        }

        int max = 0;

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
//                System.out.print(dp[i][j] + " ");
                max = Math.max(max, dp[i][j]);
            }
//            System.out.println();
        }

        System.out.println(max);
    }

    public static void initDp() {
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
        dp[1][1] = sticks[1];
    }
}