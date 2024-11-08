import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] weights;
    static int[] values;
    static int[] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        weights = new int[N+1];
        values = new int[N+1];

        dp = new int[M+1];
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        initDp();

        for(int i=1;i<=M;i++) {
            for(int j=1;j<=N;j++) {
                if(i >= weights[j]) {
                    dp[i] = Math.max(dp[i], dp[i-weights[j]] + values[j]);
                }
            }
        }

        int max = 0;
        for(int i=0;i<=M;i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    public static void initDp() {
        for(int i=0;i<=M;i++) {
            dp[i] = 0;
        }
    }
}