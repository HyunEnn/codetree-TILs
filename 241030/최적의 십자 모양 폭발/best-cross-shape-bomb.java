import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int[][] cpMap;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean[][] v;
    static int[][] map;
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

        // (0,0) ~ (n-1,n-1)까지 순차적으로 폭발을 하나씩 해봄
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bomb(i, j);
                // System.out.println("findMate : " + findMate() + " => " + i + " " + j);
                max = Math.max(max, findMate());
            }
        }
        // 폭발 후에, 상하좌우로 쌍이 되는 최대 개수를 리턴
        System.out.println(max);
    }

    public static void bomb(int i, int j) {
        copyMap();
        // 자기가 터지고 시작
        int cnt = cpMap[i][j];
        cpMap[i][j] = 0;
        // cnt 만큼 터질 개수 설정
        for (int k = 0; k < 4; k++) {
            for (int m = 1; m < cnt; m++) {
                int nr = i + (dr[k] * m);
                int nc = j + (dc[k] * m);
                if (inRange(nr, nc)) {
                    cpMap[nr][nc] = 0;
                }
            }
        }
        // 빈 칸을 위의 값으로 채우는 방식으로 변경
        for (int c = 0; c < N; c++) {
            int r = N - 1;
            while (r >= 0) {
                // 현재 위치가 빈 칸인 경우
                if (cpMap[r][c] == 0) {
                    // 위쪽에서 가장 가까운 숫자를 찾기
                    int a = r - 1;
                    while (a >= 0 && cpMap[a][c] == 0) {
                        a--;
                    }
                    // 위쪽에서 숫자를 찾았다면 해당 숫자를 현재 위치로 이동
                    if (a >= 0) {
                        cpMap[r][c] = cpMap[a][c];
                        cpMap[a][c] = 0;
                    }
                }
                r--; // 다음 행으로 이동
            }
        }
        // printMap();
    }

    public static int findMate() {
        v = new boolean[N][N];
        int cnt = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                v[i][j] = true;
                for(int k=0;k<4;k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (inRange(nr, nc)) {
                        if(!v[nr][nc] && cpMap[i][j] != 0 && cpMap[nr][nc] == cpMap[i][j]) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static void printMap() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(cpMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void copyMap() {
        cpMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cpMap[i][j] = map[i][j];
            }
        }
    }
}