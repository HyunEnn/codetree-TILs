import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static int[][] map;
    static int[][] dp;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];
        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static boolean canGo(int r, int c, int nr, int nc) {
        if (!inRange(nr, nc))
            return false;
        if (map[nr][nc] > map[r][c] && !v[nr][nc])
            return true;
        return false;
    }

    public static void dfs(int r, int c) {
        if(dp[r][c] != 0) return;
        dp[r][c] = 1;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (canGo(r, c, nr, nc)) {
                if(dp[nr][nc] == 0) dfs(nr, nc);
                dp[r][c] = Math.max(dp[r][c], dp[nr][nc] + 1);
            }
        }
    }
}