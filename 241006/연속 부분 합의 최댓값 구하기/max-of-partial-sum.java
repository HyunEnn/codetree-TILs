import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int[] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N+1];
        initDP();
        for(int i=2;i<=N;i++) {
            // 이전 값의 합과 새로 시작하는 것중에 큰 것을 고름
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    static void initDP() {
        dp[1] = arr[1];
    }
}