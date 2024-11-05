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
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
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

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(dp[i][j] == 0)
                    bfs(i, j);
            }
        }

        int max = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(max);
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static boolean canGo(int r, int c, int nr, int nc) {
        if(!inRange(nr, nc))
            return false;
        if(map[nr][nc] > map[r][c])
            return true;
        return false;
    }

    public static void bfs(int r, int c) {
        dp[r][c] = 1;
        Queue<Point> Q = new ArrayDeque<>();
        Q.offer(new Point(r, c));
        while(!Q.isEmpty()) {
            Point p = Q.poll();
            for(int k=0;k<4;k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if(canGo(p.r, p.c, nr, nc)) {
                    dp[nr][nc] = Math.max(dp[nr][nc], dp[p.r][p.c] + 1);
                    Q.offer(new Point(nr, nc));
                }
            }
        }
    }
}