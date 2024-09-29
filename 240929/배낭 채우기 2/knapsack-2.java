import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static StringTokenizer st;
    static int[][] dp;
    static int[] weights;
    static int[] values;
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        weights = new int[N+1];
        values = new int[N+1];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N+1][M+1];
        int max = 0;

        initDP();
        // 선택하는 경우
        for(int i=1;i<=N;i++) {
            // 가방의 최대 무게
            for(int j=1;j<=M;j++) {
                int currWeight = weights[i];
                int currValue = values[i];
                if(j >= currWeight) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-currWeight] + currValue);
                }
                else 
                    dp[i][j] = dp[i-1][j];
            }
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }

    public static void initDP() {
        for(int i=0;i<=N;i++) {
            for(int j=0;j<=M;j++) {
                dp[i][j] = 0;
            }
        }
    }
}