import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] dp;
    static int INT_MAX = Integer.MAX_VALUE;
    static int[] arr;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        initDP();
        for(int i=0;i<N;i++) {
            for(int j=M;j>=0;j--) {
                if(j >= arr[i]) {
                    if(dp[j-arr[i]] == INT_MAX) continue;
                    dp[j] = Math.min(dp[j], dp[j-arr[i]] + 1);
                }
            }
        }

        if(dp[M] == INT_MAX) {
            System.out.println(-1);
        } else {
            System.out.println(dp[M]);
        }
    }

    public static void initDP() {
        dp = new int[M+1];
        for(int i=1;i<=M;i++) {
            dp[i] = INT_MAX;
        }
    }
}