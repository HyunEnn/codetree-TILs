import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] bags;
    static int INT_MIN = Integer.MIN_VALUE;
    static int[][] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가방 갯수
        M = Integer.parseInt(st.nextToken()); // 최대 무게
        bags = new int[N+1][2];
        dp = new int[N+1][M+1]; // dp 는 N은 선택 갯수, M은 최대 무게로 가정
        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            bags[i][0] = Integer.parseInt(st.nextToken()); // 가방 무게
            bags[i][1] = Integer.parseInt(st.nextToken()); // 가방 가치
        }

        initDP();
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                int itemWeight = bags[i][0];
                int itemValue = bags[i][1];
                if(itemWeight > j)
                    dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-itemWeight]+itemValue);
                }
            }
        }

        int max = 0;
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }

    public static void initDP() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                dp[i][j] = 0;
            }
        }
    }
}