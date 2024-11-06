import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        initDP();
        for(int i=1;i<N;i++) {
            for(int j=0;j<i;j++) {
                if(dp[j] == Integer.MIN_VALUE) {
                    continue;
                }
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i=0;i<N;i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    public static void initDP() {
        for(int i=0;i<N;i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        dp[0] = 1;
    }
}