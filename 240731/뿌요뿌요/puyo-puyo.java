import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int cnt;
    static int res;
    static int anotherRes;
    static int bomb = 0;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] v;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        v = new boolean[N][N];
        res = Integer.MIN_VALUE;
        anotherRes = 0;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // (0,0) ~ (N,N) 까지 전부 탐색
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                cnt = 1;
                if(map[i][j] != 0)
                    puyo(i, j);

                // puyo를 통해 나온 값이 4 이상이면 전부 다 0으로 초기화하면서 최대값 비교 갱신
                if(cnt >= 4) {
                    res = Math.max(res, cnt);
                    bomb++;
                    changeMap();
                } else {
                    anotherRes = Math.max(anotherRes, cnt);
                } // cnt가 4가 안될 경우 일단 최대 블록 크기 계산만 진행
            }
        }
        if(bomb != 0)
            System.out.println(bomb + " " + res);
        else
            System.out.println(bomb + " " + anotherRes);
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static boolean canGo(int r, int c,int nr, int nc) {
        // 범위 체크
        if(!inRange(nr, nc))
            return false;
        // 방문 배열 체크와 기존 값과 같은지 체크
        if(!v[nr][nc] && map[nr][nc] == map[r][c])
            return true;
        return false;
    }

    public static void changeMap() {

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(v[i][j])
                    map[i][j] = 0;
            }
        }
    }

    public static void puyo(int r, int c) {
        // 4방 탐색을 진행하면서 동일한 값이 몇개인지 체크
        v[r][c] = true;
        for(int k=0;k<4;k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if(canGo(r, c, nr, nc)) {
                cnt++;
                puyo(nr, nc);
            }
        }
    }
}