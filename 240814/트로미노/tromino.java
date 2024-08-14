import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;

        for(int i=0;i<N-1;i++) {
            for(int j=0;j<M-1;j++) {
                max = Math.max(max, findFirst(i, j));
            }
        }
        // 4 * 5  ㅡ 모양 먼저
        for(int i=0;i<N;i++) {
            for(int j=0;j<M-2;j++) {
                max = Math.max(max, findSecond(i, j));
            }
        }
        // ㅣ 모양 체크
        for(int j=0;j<M;j++) {
            for(int i=0;i<N-2;i++) {
                max = Math.max(max, findSecondNext(i, j));
            }
        }
        System.out.println(max);
//        findSecond();
    }

    public static int findFirst(int r, int c) {
        int[] sel = new int[4];
        int idx = 0;
        for(int i=r;i<r+2;i++) {
            for(int j=c;j<c+2;j++) {
                sel[idx++] = map[i][j];
            }
        }
        Arrays.sort(sel);
        return sel[1] + sel[2] + sel[3];
    }
    // ㄴ 블럭 : 4개 가능
    // ㅡ 블럭 : 2개 가능
    public static int findSecond(int r, int c) {
        int num = 0;
        for(int i=c;i<c+3;i++) {
            num += map[r][i];
        }
        return num;
    }

    public static int findSecondNext(int r, int c) {
        int num = 0;
        for(int i=r;i<r+3;i++) {
            num += map[i][c];
        }
        return num;
    }
}