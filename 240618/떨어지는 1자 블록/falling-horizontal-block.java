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

        // 만약 격자가 1크기로 주어지면, 주어지는 블럭과 비교하고 들어갈 수 있는 지 체크
        if(N == 1) {
            boolean flag = false;
            for(int i=K;i<K+M;i++) {
                if(map[0][i] != 0) {
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                for(int i=K;i<K+M;i++) {
                    map[0][i] = 1;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            // 검사 시에 불가능이 판단되면, i - 1 자리에 블록을 위치시킨다.
            if(!checkBlock(i)) {
                move(i-1);
                break;
            }
        }

        // 탐색을 다 돌았는 데에도, move 함수가 출력이 안되면 여기서 출력
        move(N-1);

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