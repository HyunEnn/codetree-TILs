import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int ans = Integer.MAX_VALUE;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static boolean[][] v;
    static List<Pair> list = new ArrayList<>();
    static char[][] map;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        v = new boolean[N][N];

        int startR = 0, startC = 0;

        for(int i=0;i<N;i++) {
            String line = br.readLine();
            for(int j=0;j<N;j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'S') {
                    startR = i;
                    startC = j;
                }
            }
        }

        recursive(startR, startC, 0, 0);
        if(ans != Integer.MAX_VALUE)
            System.out.println(ans);
        else
            System.out.println(-1);
    }

    public static boolean inRange(int r, int c) {

        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static void recursive(int r, int c, int cnt, int ch) {

        if(map[r][c] == 'E' && ch >= 3) {
            ans = Math.min(ans, cnt);
            return;
        }

        for(int k=0;k<4;k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if(inRange(nr, nc) && !v[nr][nc]) {
                if(map[nr][nc] != '.' && map[nr][nc] != 'S' && map[nr][nc] != 'E') {
                    v[nr][nc] = true;
                    recursive(nr, nc, cnt + 1, ch + 1);
                    v[nr][nc] = false;
                }
                else {
                    v[nr][nc] = true;
                    recursive(nr, nc, cnt + 1, ch);
                    v[nr][nc] = false;
                }
            }
        }
    }
}