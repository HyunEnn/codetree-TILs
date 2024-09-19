import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;
    static int[] sticks;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sticks = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            sticks[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N+1];

        initDP();
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                if(i >= j) {
                    dp[i] = Math.max(dp[i], dp[i-j] + sticks[j]);
                }
            }
        }

//        for(int i=1;i<=N;i++) {
//            System.out.print(dp[i] + " ");
//        }
        System.out.println(dp[N]);
    }

    public static void initDP() {
        for(int i=0;i<=N;i++) {
            dp[i] = 0;
        }
    }
}