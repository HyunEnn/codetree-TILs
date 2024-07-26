import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int ans = Integer.MAX_VALUE;
    static int N;
    static int[][] map;
    static StringTokenizer st;
    static List<Integer> list = new ArrayList<>();
    static boolean[] v;
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

        v[0] = true;
        list.add(0);
        recursive(1);
        System.out.println(ans);
    }

    public static void recursive(int idx) {

        int sum = 0;
        if(idx == N) {
            for(int i = 0;i<list.size() - 1;i++) {
                int currNum = map[list.get(i)][list.get(i+1)];
                if(currNum == 0)
                    return;
                sum += currNum;
            }
            int lastPos = list.get(list.size() - 1);
            int lastCurr = map[lastPos][0];
            sum += lastCurr;

            ans = Math.min(ans, sum);
        }

        for(int i=0;i<N;i++) {
            if(!v[i]) {
                v[i] = true;
                list.add(i);
                recursive(idx + 1);
                list.remove(list.size() - 1);
                v[i] = false;
            }
        }
    }
}