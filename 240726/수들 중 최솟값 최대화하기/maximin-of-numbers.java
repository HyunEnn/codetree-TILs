import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static List<Integer> list = new ArrayList<>();
    static boolean[] v;
    static int ans = Integer.MIN_VALUE;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        v = new boolean[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(0);
        System.out.println(ans);
    }

    public static void recursive(int idx) {

        if(idx == N) {
            ans = Math.max(ans, calculate());
            return;
        }

        for(int i=0;i<N;i++) {
            if(!v[i]) {
                v[i] = true;
                list.add(map[idx][i]);
                recursive(idx + 1);
                list.remove(list.size() - 1);
                v[i] = false;
            }
        }
    }

    public static int calculate() {

        int min = Integer.MAX_VALUE;
        for(int i : list) {
            min = Math.min(min, i);
        }
        return min;
    }
}