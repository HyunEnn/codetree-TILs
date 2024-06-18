import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static int[][] map;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()) - 1;
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            // 검사 시에 불가능이 판단되면, i - 1 자리에 블록을 위치시킨다.
            if(!checkBlock(i)) {
                move(i-1);
                break;
            }
        }

        printMap();
    }

    public static void move(int r) {

        for(int i=K;i<K+M;i++) {
            map[r][i] = 1;
        }
    }

    public static boolean checkBlock(int r) {

        // K = 0, M = 3, 0 ~ 2까지 검사
        for (int j = K; j < K + M; j++) {
            if (map[r][j] != 0)
                return false;
        }
        return true;
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