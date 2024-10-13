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
    static int N, M;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] v;
    static boolean[][] melt;
    static List<Point> glaciers;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        int melting = 0;
        // 현재 빙산의 위치가 지워져도 되는지 안되는지 판단을 어떻게?
        while(true) {
            // 녹일 빙하가 있는 지? 없으면 종료
            if(!checkMelt()) {
                break;
            }
            melting = 0;
            // 외부 물 찾기 + 근접한 빙하 찾기 ( (0,0)을 선택해서 BFS 를 통해 외부 물 LIST 에 저장 )
            initV();
            glaciers = new ArrayList<>();
            externalWater();

            // 외부 물에 접근한 빙산은 녹이기
            for(Point p : glaciers) {
                map[p.r][p.c] = 0;
                melting++;
            }

            // 녹은 빙하의 개수 세기
            time++;
        }
        System.out.println(time + " " + melting);
    }

    public static boolean checkMelt() {

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(map[i][j] == 1) return true;
            }
        }
        return false;
    }

    public static void initV() {
        v = new boolean[N][M];
        melt = new boolean[N][M];
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    public static boolean canGo(int r, int c) {
        if(!inRange(r, c))
            return false;
        if(map[r][c] == 0 && !v[r][c])
            return true;
        return false;
    }

    public static void externalWater() {
        Queue<Point> Q = new ArrayDeque<>();
        v[0][0] = true;
        Q.offer(new Point(0, 0));

        while(!Q.isEmpty()) {
            Point p = Q.poll();
            for(int i=0;i<4;i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if(canGo(nr, nc)) {
                    v[nr][nc] = true;
                    Q.offer(new Point(nr, nc));
                    // 근접한 빙하 찾기
                    for(int j=0;j<4;j++) {
                        int pr = nr + dr[j];
                        int pc = nc + dc[j];
                        if(inRange(pr, pc) && map[pr][pc] == 1 && !melt[pr][pc]) {
                            melt[pr][pc] = true;
                            glaciers.add(new Point(pr, pc));
                        }
                    }
                }
            }
        }
    }

}