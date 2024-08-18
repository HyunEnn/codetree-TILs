import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = -1;
        }

        dp[0] = 0;
        dp[1] = 0;
        for(int i=1;i<=N;i++) {
            for(int j=0;j<i;j++) {
                if(dp[j] == -1)
                    continue;
                if(arr[j] + j >= i) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for(int i=1;i<=N;i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}