import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static class Pair implements Comparable<Pair>{
        int num, r, c;
        Pair(int num, int r, int c) {
            this.num = num;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Pair p) {
            return this.num - p.num;
        }
    }
    static int[][] map;
    static List<Pair> list = new ArrayList<>();
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
                list.add(new Pair(map[i][j], i, j));
                dp[i][j] = 1;
            }
        }

        Collections.sort(list);
        for(int i=0;i<list.size();i++) {
            Pair p = list.get(i);
            for(int k=0;k<4;k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if(canGo(p.r, p.c, nr, nc)) {
                    dp[nr][nc] = Math.max(dp[nr][nc], dp[p.r][p.c] + 1);
                }
            }
        }

        int res = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                res = Math.max(res, dp[i][j]);
            }
        }
        System.out.println(res);
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
}