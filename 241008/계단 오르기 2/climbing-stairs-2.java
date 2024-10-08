import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] stairs;
    static int[][] dp;
    static int max = Integer.MIN_VALUE;
    static final int choose = 3;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N + 1][choose + 1];
        initDP();
        
        for(int i=3;i<=N;i++) {
            for(int j=0;j<=choose;j++) {
                // 2칸씩 올라가는 값
                if(dp[i-2][j] != 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-2][j] + stairs[i]);
                }
                // 1칸씩 올리는 값
                if(j > 0 && dp[i-1][j-1] != 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + stairs[i]);
                }
            }
        }

        
        for(int j=1;j<=choose;j++) {
            max = Math.max(max, dp[N][j]);
        }

        System.out.println(max);
    }

    static void initDP() {
        dp[1][1] = stairs[1]; // j 가 1칸씩 올라가는 횟수로 1번
        dp[2][0] = stairs[2]; // 2칸 올라가니까 0번
        dp[2][2] = stairs[1] + stairs[2]; // 1칸씩 2번 올려서 2번
    }

}