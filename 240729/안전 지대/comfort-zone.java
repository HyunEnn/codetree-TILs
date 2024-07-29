import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] v;
    static int[][] map;
    static int[][] cMap;
    static List<Integer> list = new ArrayList<>();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cMap = new int[N][M];

        int max = 0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }
        K = 1;

        list.add(0);
        while(K <= max) {
            copyMap();
            v = new boolean[N][M];
            checkMap(K);
            int cnt = 0;
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(!v[i][j] && cMap[i][j] != 0) {
                        v[i][j] = true;
                        cnt++;
                        DFS(i, j);
                    }
                }
            }
            list.add(cnt);
            K++;
        }

        int maxNum = 0;
        for(int i=1;i<list.size();i++) {
            if(list.get(maxNum) < list.get(i)) {
                maxNum = i;
            }
        }
        System.out.println(maxNum + " " + list.get(maxNum));
    }

    public static void copyMap() {

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                cMap[i][j] = map[i][j];
            }
        }
    }

    public static void checkMap(int idx) {

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(cMap[i][j] <= idx)
                    cMap[i][j] = 0;
            }
        }
    }

    public static boolean inRange(int r, int c) {

        return r >= 0 && r < N && c >= 0 && c < M;
    }

    public static boolean isSafe(int nr, int nc) {

        if(!inRange(nr, nc))
            return false;
        if(!v[nr][nc] && cMap[nr][nc] != 0)
            return true;
        return false;
    }

    public static void DFS(int r, int c) {

        for(int k=0;k<4;k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if(isSafe(nr, nc)) {
                v[nr][nc] = true;
                DFS(nr, nc);
            }
        }
    }
}