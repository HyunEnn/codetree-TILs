import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] bags;
    static int[][] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        bags = new int[N+1][2];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i][0] = Integer.parseInt(st.nextToken());
            bags[i][1] = Integer.parseInt(st.nextToken());
        }
         dp = new int[N+1][M+1];

        // 가방 갯수
        for(int i=1;i<=N;i++) {
            // 무게 만큼
            for(int j=1;j<=M;j++) {
                // 가방의 무게와 가치
                int itemWeight = bags[i][0];
                int itemValue = bags[i][1];
                // 가방의 무게가 총 무게보다 크면
                if(j >= itemWeight)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-itemWeight] + itemValue);
            }
        }

//        for(int i=1;i<=N;i++) {
//            for(int j=1;j<=M;j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[N][M]);
    }
}