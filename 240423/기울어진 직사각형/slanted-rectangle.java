import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt, loc;
    static int[][] map;
    static int max;
    static boolean[][] v;
    static int[] dr = {-1, -1, 1, 1};
    static int[] dc = {1, -1, -1, 1};
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        max = Integer.MIN_VALUE;
        cnt = 0; // solve를 돌면서 값 체크
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=2;i<N;i++) {
            for(int j=0;j<N;j++) {
                loc = 0;
                v = new boolean[N][N];
                solve(i, j);
                max = Math.max(max, cnt);
            }
        }

        System.out.println(max);
    }

    public static void solve(int r, int c) {
        cnt = map[r][c];
        boolean flag = false;
        while(loc < 3) {
            int ch = 0;
            while(true) {
                int nr = r + dr[loc];
                int nc = c + dc[loc];
                if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1 ) {
                    if(ch == 0) {
                        cnt = 0;
                        return;
                    }

                    break;
                }
                if(!v[nr][nc]) {
                    v[nr][nc] = true;
                    cnt += map[nr][nc];
                    r = nr;
                    c = nc;
                    ch++;
                }
            }
            loc++;
        }

    }

}