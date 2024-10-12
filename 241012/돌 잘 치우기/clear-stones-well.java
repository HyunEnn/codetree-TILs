import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, K, M;
    static int cnt;
    static int[][] copyMap;
    static int[][] map;
    static List<Point> list = new ArrayList<>();
    static List<Point> ones = new ArrayList<>();
    static boolean[] v;
    static int max = Integer.MIN_VALUE;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        copyMap = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)
                    ones.add(new Point(i, j));
            }
        }

        v = new boolean[ones.size()];
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            list.add(new Point(r, c));
        }

        // 모든 가능한 경우의 조합을 생각해야 함.
        recursive(0,0);
        System.out.println(max);
    }

    public static void recursive(int curr, int cnt) {
        if(cnt == M) {
            bfs();
            int ch = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(copyMap[i][j] == 2) ch++;
                }
            }
            max = Math.max(max, ch);
            return;
        }

        // 조합으로 이전 값 비교 필요 X
        for(int i=curr;i<ones.size();i++) {
            if(!v[i]) {
                v[i] = true;
                recursive(i+1,cnt + 1);
                v[i] = false;
            }
        }
    }

    public static void copyMap() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }

    public static void bfs() {
        // 선 지도 복사
        copyMap();
        Queue<Point> Q = new ArrayDeque<>();
        for(int i=0;i<v.length;i++) {
            if(v[i]) {
                Point p = ones.get(i);
                copyMap[p.r][p.c] = 0;
            }
        }
        // 시작 값 위치 저장
        for(Point p : list) {
            Q.offer(new Point(p.r, p.c));
        }

        while(!Q.isEmpty()) {
            Point p = Q.poll();
            // 현재 위치가 가능한지?
            if(copyMap[p.r][p.c] == 0) {
                copyMap[p.r][p.c] = 2;
                for(int k=0;k<4;k++) {
                    int nr = p.r + dr[k];
                    int nc = p.c + dc[k];
                    if(canGo(nr, nc)) {
                        Q.offer(new Point(nr, nc));
                    }
                }
            }
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static boolean canGo(int r, int c) {
        if(!inRange(r, c))
            return false;
        if(copyMap[r][c] == 0)
            return true;
        return false;
    }
}