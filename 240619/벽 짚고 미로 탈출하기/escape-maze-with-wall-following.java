import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, R, C;
    static int time;
    static int direction;
    static int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
    static int[] dc = {1, 0, -1, 0};
    static char[][] map;
    static boolean[][][] v;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        time = 0;
        direction = 0;
        v = new boolean[N][N][4];
        map = new char[N][N];

        for(int i=0;i<N;i++) {
            String line = br.readLine();
            for(int j=0;j<N;j++) {
                map[i][j] = line.charAt(j);
            }
        }

        do {
            solution();
        } while(inRange(R, C));
        System.out.println(time);
    }

    public static boolean inRange(int r, int c) {

        return 0 <= r && r < N && 0 <= c && c < N;
    }

    public static void checkRight(int r, int c) {

        int tr = r + dr[(direction + 1) % 4];
        int tc = c + dc[(direction + 1) % 4];
        if(!checkBlock(tr, tc)) { // 벽이 없다면
            direction = (direction + 1) % 4;
            R = r + dr[direction];
            C = c + dc[direction];
            time += 2;
        } else { // 벽이 있다면
            R = r;
            C = c;
            time++;
        }
    }

    public static boolean checkBlock(int r, int c) {

        // 벽이 있으면 true
        if(inRange(r, c) && map[r][c] == '#') return true;
        else return false;
    }

    public static void solution() {

        // 방문한 기록이 있다면 바로 종료
        if(v[R][C][direction]) {
            System.out.println(-1);
            System.exit(0);
        }
        v[R][C][direction] = true;

        int nr = R + dr[direction];
        int nc = C + dc[direction];
        // 여기서 바로 옆에 벽이 있는지 체크
        if(checkBlock(nr, nc)) {
            if(direction == 0)
                direction = 3;
            else
                direction--;
        }
        /**
         * 이동 가능한 경우,
         * 1. 격자 밖이면 탈출
         * 2. 이동한 위치 기준 오른쪽에 짚을 벽이 있다면 그대로
         * 3. 이동한 위치 기준 오른쪽에 짚을 벽이 없다면, 시계 방향 회전 후 한칸 더 전진
         */
        else if(!inRange(nr, nc)) {
            R = nr; C = nc;
            time++;
        }
        else {
            checkRight(nr, nc);
        }
    }
}