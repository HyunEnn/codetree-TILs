import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static int ans = 0;
    static int[] dr = {1, 0};
    static int[] dc = {0, 1};
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // 1이면 뱀이 없는 경우, 0이면 뱀이 있는 경우
            }
        }

        DFS(0, 0);
        System.out.println(ans);
    }

    public static boolean isRange(int r, int c) {

        return r >= 0 && r < N && c >=0 && c < M;
    }

    public static boolean canGo(int nr, int nc) {

        if(map[nr][nc] == 1 && !v[nr][nc])
            return true;
        return false;
    }

    public static void DFS(int r, int c) {

        v[r][c] = true;
        if(r == N-1 && c == M-1) {
            ans = 1;
            return;
        }

        for(int k=0;k<2;k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if(isRange(nr, nc)) {
                if(canGo(nr, nc)) {
                    DFS(nr, nc);
                }
            }
        }
    }
}