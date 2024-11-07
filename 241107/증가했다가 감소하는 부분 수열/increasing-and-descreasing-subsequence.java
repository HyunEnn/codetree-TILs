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
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        initDP();
        // 상승을 잡고 상승 dp 이후에 하향 dp를 생각한다?
        for(int i=1;i<N;i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == Integer.MIN_VALUE) continue;
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        // 하향 dp
        for(int i=1;i<N;i++) {
            for(int j=0;j<i;j++) {
                if(dp[j] == Integer.MIN_VALUE) continue;
                if(arr[i] < arr[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
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