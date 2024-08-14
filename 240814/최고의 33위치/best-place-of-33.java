import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int res = 0;
        map = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N-2;i++) {
            for(int j=0;j<N-2;j++) {
                res = Math.max(res, findCoin(i, j));
            }
        }

        System.out.println(res);
    }

    public static int findCoin(int r, int c) {
        int cnt = 0;
        for(int i=r;i<r+3;i++) {
            for(int j=c;j<c+3;j++) {
                if(map[i][j] == 1)
                    cnt++;
            }
        }
        return cnt;
    }
}