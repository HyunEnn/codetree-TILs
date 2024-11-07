import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        initDP();
        for(int i=1;i<=M;i++) {
            for(int j=0;j<arr.length;j++) {
                if(i >= arr[j]) {
                    if(dp[i-arr[j]] == Integer.MAX_VALUE) continue;
                    dp[i] = Math.min(dp[i], dp[i-arr[j]] + 1);
                }
            }
        }

        if(dp[M] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else
            System.out.println(dp[M]);
    }

    public static void initDP() {
        for(int i=1;i<=M;i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
    }
}