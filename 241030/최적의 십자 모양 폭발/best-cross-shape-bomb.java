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
        // 터진 걸 기준으로 빈 값들을 채운다.
        for(int c=0;c<N;c++) {
            for(int r=N-1;r>0;r--) {
                // 터진 칸이면 위부터 한 칸 씩 땡김
                if(cpMap[r][c] == 0) {
                    for(int a=r;a>0;a--) {
                        cpMap[a][c] = cpMap[a-1][c];
                    } cpMap[0][c] = 0;
                }
            }
        }
    }

    public static int findMate() {
        v = new boolean[N][N];
        int cnt = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                v[i][j] = true;
                for(int k=0;k<N;k++) {
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