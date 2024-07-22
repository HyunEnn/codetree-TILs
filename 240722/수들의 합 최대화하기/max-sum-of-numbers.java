import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static List<Integer> list = new ArrayList<>();
    static boolean[] vr;
    static boolean[] vc;
    static int ans = Integer.MIN_VALUE;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        vr = new boolean[N];
        vc = new boolean[N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        choose(0);
        System.out.println(ans);
    }

    public static int sum() {

        int res = 0;
        for(int i : list) {
            res += i;
        }
        return res;
    }

    public static void choose(int idx) {

        if(idx == N) {
            ans = Math.max(ans, sum());
            return;
        }

        for(int i=0;i<N;i++) {
            if(!vr[i]) {
                vr[i] = true;
                for(int j=0;j<N;j++) {
                    if(!vc[j]) {
                        vc[j] = true;
                        list.add(map[i][j]);
                        choose(idx + 1);
                        list.remove(list.size() - 1);
                        vc[j] = false;
                    }
                }
                vr[i] = false;
            }
        }
    }
}