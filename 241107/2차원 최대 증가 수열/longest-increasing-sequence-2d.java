import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initDP();

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                for(int k=0;k<i;k++) {
                    for(int t=0;t<j;t++) {
                        if(dp[k][t] == Integer.MIN_VALUE) continue;
                        if(map[i][j] > map[k][t]) {
                            dp[i][j] = Math.max(dp[i][j], dp[k][t] + 1);
                        }
                    }
                }
            }
        }
        int max = 0;

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }

    public static void initDP() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 1;
    }
}