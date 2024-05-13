import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, Q;
    static int[][] map;
    static int[][] copyMap;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int r1, c1, r2, c2;
    static int rTemp, dTemp, lTemp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(Q != 0) {

            st = new StringTokenizer(br.readLine());
            // 시작 좌표
            r1 = Integer.parseInt(st.nextToken()) - 1;
            c1 = Integer.parseInt(st.nextToken()) - 1;
            // 마지막 좌표
            r2 = Integer.parseInt(st.nextToken()) - 1;
            c2 = Integer.parseInt(st.nextToken()) - 1;
        } else {
            printMap();
        }


        int st = 0;
        /**
         * Q 의 횟수 만큼 while 문이 반복되야 함.
         * 회전시키고 직사각형의 평균값 상하좌우와 자기자신을 더하고
         * 더한 만큼 나눈 값이 새로운 값으로 저장되야 함.
         * left 로 보낼 때의 처리가 중요함. ( 값을 따로 저장해준다? )
         */

        while(st < Q) {
            // 한 바퀴 돌고
            right();
            down();
            left();
            up();
            // 본인 포함 사방 탐색 진행 하고 평균값 적용
            changeAvg();
            moveMap();
            printMap();
            st++;
        }
    }

    public static void changeAvg() {

        copyMap = new int[N][M];
        for(int i=r1;i<=r2;i++) {
            for(int j=c1;j<=c2;j++) {
                int sum = map[i][j];
                int cnt = 1;
                for(int k=0;k<4;k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    // 범위 안에 있으면, cnt 증가하고 sum 값에 더해줌
                    if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                        sum += map[nr][nc];
                        cnt++;
                    }
                }
                copyMap[i][j] = sum / cnt;
            }
        }
    }

    public static void moveMap() {

        for(int i=r1;i<=r2;i++) {
            for(int j=c1;j<=c2;j++) {
                map[i][j] = copyMap[i][j];
            }
        }
    }

    public static void right() {

        rTemp = map[r1][c2];
        for(int i=c2;i>c1;i--) {
            map[r1][i] = map[r1][i-1];
        }
    }

    public static void down() {

        dTemp = map[r2][c2];
        for(int i=r2;i>r1+1;i--) {
            map[i][c2] = map[i-1][c2];
        }
        map[r1+1][c2] = rTemp;
    }

    public static void left() {

        lTemp = map[r2][c1];
        for(int i=c1;i<c2-1;i++) {
            map[r2][i] = map[r2][i+1];
        }
        map[r2][c2-1] = dTemp;
    }

    public static void up() {

        for(int i=r1;i<r2-1;i++) {
            map[i][c1] = map[i+1][c1];
        }
        map[r2-1][c1] = lTemp; // 빼둔 값을 적용
    }

    public static void printMap() {

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}