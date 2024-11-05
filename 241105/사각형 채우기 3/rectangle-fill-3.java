import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] dp;
    static int mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<=N;i++) {
            dp[i] = (dp[i-1]*2 + dp[i-2]*3) % mod;
            for(int j=i-3;j>=0;j--) {
                dp[i] = (dp[i] + dp[j] * 2) % mod;
            }
        }
        System.out.println(dp[N]);
    }


}