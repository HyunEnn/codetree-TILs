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
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                for(int k=0;k<i;k++) {
                    for(int l=0;l<j;l++) {
                        if(dp[k][l] == 0)
                            continue;

                        if(map[k][l] < map[i][j]) {
                            dp[i][j] = Math.max(dp[i][j], dp[k][l] + 1);
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
}