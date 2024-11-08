import java.util.*;
import java.io.*;

public class Main {
    static int N, M;

    static class Jew {
        int w, v;

        Jew(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    static List<Jew> bags = new ArrayList<>();
    static int[][] dp;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bags.add(new Jew(w, v));
        }

        initDP();

        for (int i = 1; i <= N; i++) {
            Jew p = bags.get(i - 1);
            for (int j = 0; j <= M; j++) {
                if (j >= p.w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - p.w] + p.v);
                } else
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }

//        for (int i = 1; i <= N; i++) {
//            for (int j = 0; j <= M; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        int max = 0;
        for (int j = 0; j <= M; j++) {
            max = Math.max(max, dp[N][j]);
        }
        System.out.println(max);
    }

    public static void initDP() {
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;
    }
}