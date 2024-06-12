import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N, M; // N = 격자 크기, M = 폭탄 갯수
    static int[][] map;
    static List<Integer> bomb = new ArrayList<>();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<M;i++) {
            int a = Integer.parseInt(br.readLine());
            bomb.add(a);
        }

        while(!bomb.isEmpty()) {
            int st = bomb.get(0) - 1;
            bomb.remove(0);
            for(int i=0;i<N;i++) {
                if(map[i][st] != 0) {
                    boom(i, st);
                }
            }

            for(int j=0;j<N;j++) {
                moveMap(j);
            }
        }

        printMap();
    }

    public static void boom(int r, int c) {

        int bombSize = map[r][c] - 1;
        for(int i=0;i<4;i++) {
            for(int j=0;j<=bombSize;j++) {
                int nr = r + (dr[i] * j);
                int nc = c + (dc[i] * j);
                if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1)
                    continue;
                map[nr][nc] = 0;
            }
        }
    }

    public static void moveMap(int c) {

        int[] tmp = new int[N];
        int tmpSize = N-1;

        for(int i=N-1;i>=0;i--) {
            if(map[i][c] != 0) {
                tmp[tmpSize--] = map[i][c];
            }
        }
        tmpSize = N-1;
        for(int i=N-1;i>=0;i--) {
            if(tmp[i] != 0) {
                map[tmpSize--][c] = tmp[i];
            }
        }

        while(tmpSize >= 0) {
            map[tmpSize--][c] = 0;
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