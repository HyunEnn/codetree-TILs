import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringTokenizer st;
    static int[][] map;
    static int cnt;
    static List<Integer> list;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        list = new ArrayList<>();

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j] == 1) {
                    map[i][j] = 2;
                    cnt = 1;
                    recursive(i, j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(int i : list) {
            System.out.println(i);
        }
    }

    public static void recursive(int r, int c) {

        for(int i=0;i<4;i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1) continue;
            if(map[nr][nc] == 1) {
                map[nr][nc] = 2;
                cnt++;
                recursive(nr, nc);
            }
        }
    }
}