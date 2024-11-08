import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[][] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        dp = new boolean[N+1][M+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        initDP();
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= M; j++) {
                if(j >= arr[i]) {
                    if(dp[i-1][j-arr[i]]) {
                        dp[i][j] = true;
                    }
                }
                if(dp[i-1][j])
                    dp[i][j] = true;
            }
        }

        if(dp[N][M])
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static void initDP() {
        dp[0][0] = true;
    }
}