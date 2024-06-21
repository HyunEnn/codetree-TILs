import java.util.*;
import java.io.*;

public class Main {
    static int N, M, R, C;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static int[] f = {4, 6, 3, 1};
    static int[] s = {5, 6, 2, 1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        map = new int[N][N];
        map[R][C] = 6;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            char c = st.nextToken().charAt(0);
            rotate(c);
        }
        System.out.println(sumMap());
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static void rotate(char dir) {

        if (dir == 'L') {
            int nr = R + dr[3];
            int nc = C + dc[3];
            if (inRange(nr, nc)) {
                int tmp = f[3];
                for (int i = 3; i >= 1; i--) {
                    f[i] = f[i - 1];
                }
                f[0] = tmp;
                s[1] = f[1];
                s[3] = f[3];
                map[nr][nc] = f[1];
                R = nr;
                C = nc;

            }
        } else if (dir == 'R') {
            int nr = R + dr[1];
            int nc = C + dc[1];
            if(inRange(nr, nc)) {
                int tmp = f[0];
                for (int i = 0; i < 3; i++) {
                    f[i] = f[i + 1];
                }
                f[3] = tmp;
                s[1] = f[1];
                s[3] = f[3];
                map[nr][nc] = f[1];
                R = nr;
                C = nc;
            }
        } else if (dir == 'U') {
            int nr = R + dr[0];
            int nc = C + dc[0];
            if(inRange(nr, nc)) {
                int tmp = s[3];
                for (int i = 3; i >= 1; i--) {
                    s[i] = s[i - 1];
                }
                s[0] = tmp;
                f[1] = s[1];
                f[3] = s[3];
                map[nr][nc] = s[1];
                R = nr;
                C = nc;
            }
        } else if (dir == 'D') {
            int nr = R + dr[2];
            int nc = C + dc[2];
            if(inRange(nr, nc)) {
                int tmp = s[0];
                for (int i = 0; i < 3; i++) {
                    s[i] = s[i + 1];
                }
                s[3] = tmp;
                f[1] = s[1];
                f[3] = s[3];
                map[nr][nc] = s[1];
                R = nr;
                C = nc;
            }
        }
    }

    public static int sumMap() {

        int sum = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }

    public static void printMap() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}