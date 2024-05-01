import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int max;
    static boolean flag;
    static boolean[][] v;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        max = Integer.MIN_VALUE;

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                for(int k=i;k<N;k++) {
                    for(int l=j;l<M;l++) {
                        // 여기서 첫 번째 직사각형 결정
                        max = Math.max(max, findMaxRectSum(i, j, k, l));
                    }
                }
            }
        }

        System.out.println(max);
    }
    public static int findMaxRectSum(int r1, int c1, int r2, int c2) {

        // 여기서 2번쨰 직사각형을 구한다.
        int max_sum = Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                for(int k=i;k<N;k++) {
                    for(int l=j;l<M;l++) {
                        //여기서 1번 직사각형과 2번 직사각형이 중복되는지 체크하고,
                        //안 겹치면, 값을 다 더하고 최대값을 구한다.
                        if(!overlapped(r1, c1, r2, c2, i, j, k, l)) {
                            // 중복이 아닐때만 max를 처리한다.
                            max_sum = Math.max(max_sum, totalsum());
                        }
                    }
                }
            }
        }
        return max_sum;
    }

    public static int totalsum() {

        int cnt = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(v[i][j])
                    cnt += map[i][j];
            }
        }
        return cnt;
    }

    public static boolean overlapped(int r1, int c1, int r2, int c2, int nr1, int nc1, int nr2, int nc2) {

        // 방문 배열 초기화
        v = new boolean[N][M];
        flag = false;
        sumRect(r1, c1, r2, c2);
        sumRect(nr1, nc1, nr2, nc2);
        // 여기서는 flag가 true면 중복 처리
        if(flag)
            return true;
        else
            return false;
    }

    public static void sumRect(int r1, int c1, int r2, int c2) {

        for(int i=r1;i<=r2;i++) {
            for(int j=c1;j<=c2;j++) {
                if(v[i][j]) { // 중복됬으면, 그냥 flag 처리하고 바로 종료
                    flag = true;
                    return;
                }
                v[i][j] = true;
            }
        }
    }
     /**
         * 첫 번째 직사각형을 기준으로 양 쪽 꼭짓점을 생각해서 구하는 값을 지정
         * 그 값과 2번째 직사각형도 똑같은 기준으로 탐색
         */
}