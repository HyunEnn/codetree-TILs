import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int INT_MIN = Integer.MIN_VALUE;
    static int[] arr;
    static int[] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        initDP();
        for(int i=0;i<N;i++) {
            for(int j=M;j>=0;j--) {
                if(j >= arr[i]) {
                    if(dp[j-arr[i]] == INT_MIN) continue;
                    dp[j] = Math.max(dp[j], dp[j-arr[i]]+1);
                }
            }
        }

        if(dp[M] == INT_MIN) 
            System.out.println("No");
        else
            System.out.println("Yes");
    }

    public static void initDP() {
        for(int i=1;i<=M;i++) {
            dp[i] = INT_MIN;
        }
    }
}