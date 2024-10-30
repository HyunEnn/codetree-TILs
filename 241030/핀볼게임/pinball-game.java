import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int max = 0;
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
        // 총 4개의 방향에서의 접근을 생각한다.
        for (int i = 0; i < N; i++) {
            max = Math.max(max, check(2, 0, i));
            max = Math.max(max, check(1, i, 0));
            max = Math.max(max, check(0, N - 1, i));
            max = Math.max(max, check(3, i, N - 1));
        }
        // 1. 0행의 0~N까지 열들을 아래 방향으로 흐르는 시작
        // 2. 0열에서 0~N까지 행들을 오른쪽으로 흐르는 시작
        // 3. N-1행에서 0~N까지 열들을 위로 흐르는 시작
        // 4. N-1열에서 0~N까지 행들을 왼쪽으로 흐르는 시작

        System.out.println(max);
        // 지도에서 1은 '/', 2는 '\'
        // 1이면 dir % 2 가 짝수면 +1 홀수면 -1 로 처리, 2이면 dir 이 홀수면 +1 짝수면 -1
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static int check(int dir, int startR, int startC) {
        int cnt = 0;
        int r = startR, c = startC;
//            System.out.println("현재 진행 순서 : " + i);
        while (inRange(r, c)) {
            // 범위안에 있는 동안만 진행하며,
//                System.out.println(r + " " + c);
            cnt++;
            if (map[r][c] == 1) {
                if (dir % 2 == 0) {
                    dir = (dir + 4 + 1) % 4;
                } else {
                    dir = (dir + 4 - 1) % 4;
                }
            } else if (map[r][c] == 2) {
                if (dir % 2 == 0) {
                    dir = (dir + 4 - 1) % 4;
                } else {
                    dir = (dir + 4 + 1) % 4;
                }
            }
            r += dr[dir];
            c += dc[dir];
        }
        cnt++;
        cnt = Math.max(max, cnt);
        return cnt;
    }
}