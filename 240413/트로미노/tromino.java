import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static int[][] map;
    static int[] first_dr = {-1, -1};
    static int[] first_dc = {0, -1};
    static int[] first_dr2 = {-1, -1};
    static int[] first_dc2 = {0, 1};
    static int[] first_dr3 = {1, 1};
    static int[] first_dc3 = {0, 1};
    static int[] first_dr4 = {1, 1};
    static int[] first_dc4 = {0, -1};
    static int[] second_dr = {0, 0};
    static int[] second_dc = {1, 2};
    static int[] second_dr2 = {1, 2};
    static int[] second_dc2 = {0, 0};
    static int max;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        max = Integer.MIN_VALUE;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                int check = solve(i, j);
                max = Math.max(max, check);
            }
        }
        System.out.println(max);
    }

    public static int solve(int r, int c) {
        int res = 0;
        res = Math.max(res, firstFigure(r, c));
        res = Math.max(res, secondFigure(r, c));
        res = Math.max(res, thirdFigure(r, c));
        res = Math.max(res, lastFigure(r, c));
        res = Math.max(res, flatFigure(r, c));
        res = Math.max(res, horFigure(r, c));
        return res;
    }

    public static int firstFigure(int r, int c) {
        int sum = map[r][c];
        for(int i=0;i<2;i++) {
            int nr = r + first_dr[i];
            int nc = c + first_dc[i];
            if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1) {
                return 0;
            }
            sum += map[nr][nc];
        }
        return sum;
    }

    public static int secondFigure(int r, int c) {
        int sum = map[r][c];
        for(int i=0;i<2;i++) {
            int nr = r + first_dr2[i];
            int nc = c + first_dc2[i];
            if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1)
                return 0;
            sum += map[nr][nc];
        }
        return sum;
    }

    public static int thirdFigure(int r, int c) {
        int sum = map[r][c];
        for(int i=0;i<2;i++) {
            int nr = r + first_dr3[i];
            int nc = c + first_dc3[i];
            if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1)
                return 0;
            sum += map[nr][nc];
        }
        return sum;
    }

    public static int lastFigure(int r, int c) {
        int sum = map[r][c];
        for(int i=0;i<2;i++) {
            int nr = r + first_dr4[i];
            int nc = c + first_dc4[i];
            if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1)
                return 0;
            sum += map[nr][nc];
        }
        return sum;
    }

    public static int flatFigure(int r, int c) {
        int sum = map[r][c];
        for(int i=0;i<2;i++) {
            int nr = r + second_dr[i];
            int nc = c + second_dc[i];
            if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1)
                return 0;
            sum += map[nr][nc];
        }
        return sum;
    }

    public static int horFigure(int r, int c) {
        int sum = map[r][c];
        for(int i=0;i<2;i++) {
            int nr = r + second_dr2[i];
            int nc = c + second_dc2[i];
            if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1)
                return 0;
            sum += map[nr][nc];
        }
        return sum;
    }
}