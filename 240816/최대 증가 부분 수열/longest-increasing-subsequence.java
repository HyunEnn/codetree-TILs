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
        dp[0] = 0;

        for(int i=1;i<N;i++) {
            for(int j=0;j<i;j++) {
                if(dp[j] == -1)
                    continue;
                if(j + arr[j] >= i) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(dp[N-1]);
    }
}