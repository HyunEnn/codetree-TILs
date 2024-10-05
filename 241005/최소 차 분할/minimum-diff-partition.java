import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[][] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        M = 0;
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            M += arr[i];
        }

        dp = new boolean[N+1][M+1];
        Arrays.sort(arr);
        initDP();

        // 선택하는 수치부터
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                // 선택하는 조건 ( arr의 선택 값이 j 보다 크거나 같고, 현재 값 고르기 전에 선택한 값이 있으면 )
                if(arr[i] <= j && dp[i-1][j-arr[i]])
                    dp[i][j] = true;
                // 기존 값 복사
                if(dp[i-1][j])
                    dp[i][j] = true;
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=1;i<=M;i++) {
            if(dp[N][i])
                min = Math.min(min, Math.abs(i - (M - i)));
        }

        System.out.println(min);
    }

    static void initDP() {
        dp[0][0] = true;
    }
}