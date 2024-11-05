import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initDP();
        // 경계값만 따로 계산 ( 가로, 세로 )
        for(int j=N-2;j>=0;j--) {
            dp[0][j] = map[0][j] + dp[0][j+1];
        }
        for(int i=1;i<N;i++) {
            dp[i][N-1] = map[i][N-1] + dp[i-1][N-1];
        }

        // 경계값 제외 나머지 부분 계산
        for(int i=1;i<N;i++) {
            for(int j=N-2;j>=0;j--) {
                dp[i][j] = Math.min(dp[i-1][j] + map[i][j], dp[i][j+1] + map[i][j]);
            }
        }
        System.out.println(dp[N-1][0]);
    }
    
    public static void initDP() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][N-1] = map[0][N-1];
    }
}