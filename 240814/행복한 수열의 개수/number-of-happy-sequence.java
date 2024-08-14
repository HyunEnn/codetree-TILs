import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, res;
    static int[][] map;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = 0;
        map = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1행 r, c 를 기준으로 총 6번의 탐색을 진행하면 됨
        // 현재 행 기준 탐색
        for(int i=0;i<N;i++) {
            int cnt = 1;
            int saveCnt = 1;
            for(int j=1;j<N;j++) {
                if(map[i][j-1] == map[i][j])
                    cnt++;
                else
                    cnt = 1;
                saveCnt = Math.max(saveCnt, cnt);
            }
            if(saveCnt >= M)
                res++;
        }
        // 열 기준 탐색
        for(int j=0;j<N;j++) {
            int cnt = 1;
            int saveCnt = 1;
            for(int i=1;i<N;i++) {
                if(map[i-1][j] == map[i][j])
                    cnt++;
                else
                    cnt = 1;
                saveCnt = Math.max(saveCnt, cnt);
            }
            if(saveCnt >= M)
                res++;
        }

        System.out.println(res);
    }
}