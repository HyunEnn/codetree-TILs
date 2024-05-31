import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] map;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int bombR = Integer.parseInt(st.nextToken()) - 1;
        int bombC = Integer.parseInt(st.nextToken()) - 1;
        if(map[bombR][bombC] > 1) {
            int range = map[bombR][bombC] - 1;
            int k = 3;
            while(k > 0) {
                for(int i=1;i<=range;i++) {
                    int nr = bombR + (dr[k] * i);
                    int nc = bombC + (dc[k] * i);
                    if(nr < 0 || nr > N-1 || nc < 0 || nc > N-1) continue;
                    map[nr][nc] = -1;
                }
                k--;
            }
        }
    }

    public static void printMap() {

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}