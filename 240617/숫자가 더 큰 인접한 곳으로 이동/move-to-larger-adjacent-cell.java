import java.util.*;
import java.io.*;

public class Main {
    static int N, R, C;
    static int max;
    static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dc = {0, 0, -1, 1};
    static List<Integer> list = new ArrayList<>();
    static int[][] map;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        map = new int[N][N];
        max = Integer.MIN_VALUE;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list.add(map[R][C]);
        move(R, C);
        for(int i : list) {
            System.out.print(i + " ");
        }
    }

    public static void move(int r, int c) {

        boolean flag = false;

        int nr = 0;
        int nc = 0;
        for(int k=0;k<4;k++) {
            nr = r + dr[k];
            nc = c + dc[k];
            if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1 || map[r][c] >= map[nr][nc])
                continue;
            list.add(map[nr][nc]);
            flag = true;
            break;
        }

        if(flag) {
            move(nr, nc);
        }
        // 4방 탐색을 마쳐도 true가 안됬으면 큰 수가 없다.
    }
}