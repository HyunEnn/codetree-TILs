import java.util.*;
import java.io.*;
public class Main {
    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }
    }
    static int N, K;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int initR, initC;
    static int maxR, maxC;
    static List<Point> list;
    static int cnt;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        initR = Integer.parseInt(st.nextToken())-1;
        initC = Integer.parseInt(st.nextToken())-1;

        if(N == 1) {
            System.out.print(1 + " " + 1);
            return;
        }
        int time = 0;
        maxR = initR; maxC = initC;
        while(time < K) {
            v = new boolean[N][N]; // bfs를 할 때마다, 매번 방문배열 초기화가 필요할 듯?
            list.removeAll(list);
            BFS(maxR, maxC);
            if(list.size() == 0) break;
            // BFS를 통해 나온 값들 중에, list를 통해서 최대 우선순위를 추출
            // 추출된 우선순위로 time에 따라, 다시 BFS 탐색을 하던, 종료를 한다.
            // 탐색 종료 후에, maxR과 maxC를 출력한다.
            ArrayList<Point> maxList = new ArrayList<>();
            int max = Integer.MIN_VALUE;

            for(Point p : list) {
                int num = map[p.r][p.c];
                max = Math.max(max, num);
            }

            for(Point p : list) {
                if(map[p.r][p.c] == max) {
                    maxList.add(new Point(p.r, p.c));
                }
            }

            maxList.sort(Comparator.comparing(Point::getR)
                    .thenComparing(Point::getC));

            maxR = maxList.get(0).getR();
            maxC = maxList.get(0).getC();
            time++;
        }

        System.out.println((maxR + 1) + " " + (maxC + 1));
    }

    public static void BFS(int r, int c) {
        Queue<Point> Q = new ArrayDeque<>();
        Q.offer(new Point(r, c));
        v[r][c] = true;
        int current = map[r][c]; // 현재 위치 값
        cnt = 0;

        while(!Q.isEmpty()) {
            Point p = Q.poll();
            for(int i=0;i<4;i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1)
                    continue;
                if(!v[nr][nc] && map[nr][nc] < current) {
                    v[nr][nc] = true;
                    Q.offer(new Point(nr, nc));
                    list.add(new Point(nr, nc));
                }
            }
            cnt++;
        }
    }

    public static void printMap() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}