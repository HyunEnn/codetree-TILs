import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] map;
    static int[][] copyMap;
    static int[] tmp;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        copyMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        while (idx <= K) {
            for (int j = 0; j < N; j++) {
                checkBomb(j);
            }

            copy();
            for (int j = N - 1; j >= 0; j--) {
                rotateMap(j);
            }
            
            // 회전한 후에, 0이 있는 자리에 값을 떨어뜨려야 함
            for(int j=0;j<N;j++) {
                moveZero(j);
            }
            idx++;
        }

        System.out.println(countMap());
//        printMap();
    }

    public static void moveZero(int c) {

        tmp = new int[N];
        int tmpSize = 0;
        // 똑같이 맨 밑 행부터 값을 저장한다.
        for(int i=N-1;i>=0;i--) {
            if(map[i][c] != 0)
                tmp[tmpSize++] = map[i][c];
        }

        tmpSize = 0;
        for(int i=N-1;i>=0;i--) {
            map[i][c] = tmp[tmpSize++];
        }
    }

    public static void checkBomb(int c) {

        int next = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            while (next < N) {
                int cnt = 1;
                for (int i = next + 1; i < N; i++) {
                    if (map[i][c] != map[next][c] || map[next][c] == 0)
                        break;
                    cnt++;
                }

                if (cnt >= M) {
                    changeBomb(next, c, cnt);
                    flag = true;
                } else {
                    flag = false;
                }
                next += cnt;
            }

            for (int j = 0; j < N; j++) {
                moveBomb(j);
            }
        }
    }

    public static void moveBomb(int c) {

        tmp = new int[N];
        int tmpSize = 0;
        for (int i = N-1; i >= 0; i--) {
            if (map[i][c] != 0)
                tmp[tmpSize++] = map[i][c];
        }

        tmpSize = 0;
        for (int i = N - 1; i >= 0; i--) {
            map[i][c] = tmp[tmpSize++];
        }
    }

    public static void changeBomb(int r, int c, int cnt) {

        for (int i = r; i < r + cnt; i++) {
            map[i][c] = 0;
        }
    }

    public static void rotateMap(int c) {

        tmp = new int[N];
        int tmpSize = 0;

        // 여기서, 마지막 열부터 끝 행부터 0이 아닌 값을 쌓는다.
        for (int i = N - 1; i >= 0; i--) {
            if (copyMap[i][c] != 0)
                tmp[tmpSize++] = copyMap[i][c];
        }

        tmpSize = 0;
        for (int i = 0; i < N; i++) {
            map[c][i] = tmp[tmpSize++];
        }
    }

    public static void copy() {

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                copyMap[i][j] = map[i][j];
            }
        }
    }

    public static void printMap() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int countMap() {

        int cnt = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j] != 0)
                    cnt++;
            }
        }
        return cnt;
    }
}