import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringTokenizer st;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = -1;
        }
        dp[0] = 1;

        for(int i=0;i<N;i++) {
            for(int j=0;j<i;j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for(int i=0;i<N;i++) {
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}