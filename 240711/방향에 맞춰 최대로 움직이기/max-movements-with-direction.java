import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int ans = Integer.MIN_VALUE;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] val;
    static int[][] map;
    static int R, C;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        val = new int[N][N];
        map = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                val[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        recursive(R, C, 0);
        System.out.println(ans);
        // 3 * 3 이면, 시작이 무조건 3행 3열?
        /**
         * 1. 처음 주어지는 N * N은 각 방향 별 번호를 의미한다?
         * 1-1. 기존에 방향 값들을 정해두고, 각 번호들이 그 방향을 가르키게 해야한다.
         * 1-2. map 2개를 활용해서, 하나는 dir, 하나는 value 받아서 dir - value 매핑시키면?
         * 2. 그리고 주어지는 판에서 움직일 수 있는 최대 값을 구하라
         */
    }

    public static void recursive(int r, int c, int cnt) {

        ans = Math.max(ans, cnt);

        int d = val[r][c] - 1;
        for(int i=1;i<=N;i++) {
            int nr = r + dr[d] * i;
            int nc = c + dc[d] * i;
            if(isPossible(nr, nc, map[r][c]))
                recursive(nr, nc, cnt + 1);
        }
    }

    public static boolean isPossible(int nr, int nc, int currMap) {

        if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
            if (map[nr][nc] > currMap)
                return true;
        }
        return false;
    }
}