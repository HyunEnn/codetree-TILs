
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int r, c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int N, M, T;
    static int[][] check;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우 순으로 매겨야함
    static int[] dc = {0, 0, -1, 1};
    static List<Point> beads = new ArrayList<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        check = new int[N][N]; // 최종 이동 격자
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            check[r][c] = 1;
        }

        int time = 0;
        while (time < T) {
            int[][] copyCheck = new int[N][N];
            // check 에 1인 값들이 있으면, 이동을 시작함
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(check[i][j] == 1) {
                        move(i, j, copyCheck);
                    }
                }
            }

            // 구슬을 한 번 이동하고, 복사함 -> 2 이상이면 0, 나머진 그대로
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(copyCheck[i][j] >= 2)
                        check[i][j] = 0;
                    else
                        check[i][j] = copyCheck[i][j];
                }
            }

            time++;
        }

        System.out.println(countCheck());
    }

    public static void move(int r, int c, int[][] copyCheck) {
        int ch = 0; // 이동 방향 정함
        int curr = 0; // 인접한 숫자들 중 가장 큰 값으로 이동
        // 이동할 방향 설정
        for(int k=0;k<4;k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if(inRange(nr, nc)) {
                if(map[nr][nc] > curr) {
                    curr = map[nr][nc];
                    ch = k;
                }
            }
        }
        // 설정된 방향 기준으로 이동
        copyCheck[r + dr[ch]][c + dc[ch]]++;
    }

    public static int countCheck() {
        int cnt = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(check[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
