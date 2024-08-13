import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int res;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        res = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
            }
        }

        for(int lower=1;lower<=100;lower++) {
            int upper = solve(lower);

            if(upper == Integer.MAX_VALUE) {
                continue;
            }

            res = Math.min(res, upper - lower);
        }
        System.out.println(res);
    }

    public static int solve(int lower) {
        for(int i=0;i<N;i++) { // 여기서 map 을 최솟값 기준으로 탐색 안하는 것들은 제거
            for(int j=0;j<N;j++) {
                if(map[i][j] < lower)
                    map[i][j] = Integer.MAX_VALUE;
            }
        }

        dp = new int[N][N]; // dp를 전부 초기화

        // 오른쪽 아래 이동에 대한 값
        dp[0][0] = map[0][0];
        for(int i=1;i<N;i++) {
            dp[i][0] = Math.max(dp[i-1][0], map[i][0]);
            dp[0][i] = Math.max(dp[0][i-1], map[0][i]);
        }
        // 나머지에 대한 dp 이동 값 계산
        for(int i=1;i<N;i++) {
            for(int j=1;j<N;j++) {
                dp[i][j] = Math.max(Math.min(dp[i-1][j], dp[i][j-1]), map[i][j]);
            }
        }
        return dp[N-1][N-1];
    }
}