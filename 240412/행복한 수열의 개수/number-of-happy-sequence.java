import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static StringTokenizer st;
    static int[][] map;
    static boolean[] v;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        v = new boolean[100];
        int answer = 0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 행복한 행 구하기
        for(int i = 0 ; i < N ; i++) {
            int tmp = 1;    // 연속한 수 갯수
            int beforeVal = map[i][0];    // 이전 값

            for(int j = 1 ; j < N ; j++) {
                if(map[i][j] == beforeVal) {
                    tmp++;
                }
                else {
                    beforeVal = map[i][j];
                    tmp = 1;
                }

                // 연속한 수 갯수가 M개 이상이라면, 정답 +1하고 탈출
                if(tmp >= M) {
                    cnt++;
                    break;
                }
            }
        }


        // 행복한 열 구하기
        for(int i = 0 ; i < N ; i++) {
            int tmp = 1;    // 연속한 수 갯수
            int beforeVal = map[0][i];    // 이전 값

            for(int j = 1 ; j < N ; j++) {
                if(map[j][i] == beforeVal) {
                    tmp++;
                }
                else {
                    beforeVal = map[j][i];
                    tmp = 1;
                }

                // 연속한 수 갯수가 M개 이상이라면, 정답 +1하고 탈출
                if(tmp >= M) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}