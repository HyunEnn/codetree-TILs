import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int[] firstR = {-2, -1, 1, 2};
    static int[] secondR = {-1, 0, 1, 0};
    static int[] secondC = {0, 1, 0, -1};
    static int[] thirdR = {-1, 1, 1, -1};
    static int[] thirdC = {1, 1, -1, -1};
    static int N;
    static int[][] map;
    static int[][] newMap;
    static StringTokenizer st;
    static List<Point> list;
    static int max;
    static boolean[][] boom;

    static class Point {
        public int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    /**
     * list 에 1인 값들을 추가 해준다.
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        newMap = new int[N][N];
        boom = new boolean[N][N];
        max = Integer.MIN_VALUE;
        list = new ArrayList<>();


        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    list.add(new Point(i, j));
                }
            }
        }

        exclusion(0);
        System.out.println(max);
    }

    public static void exclusion(int depth) {

        if(depth == list.size()) {
            max = Math.max(max, calculate());
            return;
        }


        for(int i=1;i<4;i++) {
            int nr = list.get(depth).r;
            int nc = list.get(depth).c;
            newMap[nr][nc] = i;
            exclusion(depth + 1);
            newMap[nr][nc] = 0;
        }
    }

    public static int calculate() {

        boom = new boolean[N][N]; // 폭탄 터질 곳 전부 초기화
        initBoom(); // 초기 설정된 폭탄

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(newMap[i][j] == 1) {
                    for(int k=0;k<4;k++) {
                        int nr = i + firstR[k];
                        int nc = j;
                        if(nr < 0 || nr > N-1)
                            continue;
                        boom[nr][nc] = true;
                    }
                }
                else if(newMap[i][j] == 2) {
                    for(int k=0;k<4;k++) {
                        int nr = i + secondR[k];
                        int nc = j + secondC[k];
                        if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1)
                            continue;
                        boom[nr][nc] = true;
                    }
                }
                else if(newMap[i][j] == 3) {
                    for(int k=0;k<4;k++) {
                        int nr = i + thirdR[k];
                        int nc = j + thirdC[k];
                        if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1)
                            continue;
                        boom[nr][nc] = true;
                    }
                }
            }
        }
        return checkNum();
    }

    public static void initBoom() {

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) {
                if(newMap[i][j] != 0) {
                    boom[i][j] = true;
                }
            }
        }
    }

    public static int checkNum() {

        int cnt = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(boom[i][j])
                    cnt++;
            }
        }
        return cnt;
    }

}