import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int max_size;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        max_size = Integer.MIN_VALUE;

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
                        if(isBoolRect(i, j, k, l))
                            max_size = Math.max(max_size, (k-i+1) * (l-j+1));
                    }
                }
            }
        }

        System.out.println(max_size);
    }

    public static boolean isBoolRect(int r1, int c1, int r2, int c2) {

        for(int i=r1;i<=r2;i++) {
            for(int j=c1;j<=c2;j++) {
                if(map[i][j] < 0)
                    return false;
            }
        }
        return true;
    }

    public static int findMaxRect(int r1, int c1, int r2, int c2) {

        int cnt = 0;
        for(int i=r1;i<=r2;i++) {
            for(int j=c1;j<=c2;j++) {
                if(map[i][j] < 0)
                    return 0;
                cnt++;
            }
        }
        return cnt;
    }
}