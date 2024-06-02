import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int range = map[r][c] - 1;
        int k = 3;
        while(k >= 0) {
            for(int i=0;i<=range;i++) {
                int nr = r + dr[k] * i;
                int nc = c + dc[k] * i;
                if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1)
                    continue;
                map[nr][nc] = -1;
            }
            k--;
        }

        for(int j=0;j<N;j++) {
            int[] temp = new int[N];
            int tempSize = 0;
            for(int i=0;i<N;i++) {
                if(map[i][j] != -1) {
                    temp[tempSize] = map[i][j];
                    tempSize++;
                }
            }
            for(int i=0;i<N-tempSize;i++) {
                map[i][j] = 0;
            }
            int idx = 0;
            for(int i=N-tempSize;i<N;i++) {
                map[i][j] = temp[idx];
                idx++;
            }
        }

        printMap();
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