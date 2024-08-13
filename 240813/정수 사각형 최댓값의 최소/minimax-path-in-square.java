import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
                dp[i][j] = -1;
            }
        }
        dp[0][0] = map[0][0];
        // 오른쪽, 아래 방향 진행
        for(int i=1;i<N;i++) {
            dp[i][0] = Math.max(dp[i-1][0], map[i][0]);
            dp[0][i] = Math.max(dp[0][i-1], map[0][i]);
        }
        // 위, 아래중 작은 값을 고르고 현재 값은 지나가야 하니, 현재 값이 더 크면 현재값을 채택
        for(int i=1;i<N;i++) {
            for(int j=1;j<N;j++) {
                dp[i][j] = Math.max(Math.min(dp[i-1][j], dp[i][j-1]), map[i][j]);
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}