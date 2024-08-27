import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] inc_dp;
    static int[] dec_dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        inc_dp = new int[N];
        dec_dp = new int[N];
        inc_dp[0] = 1; // 시작값은 1로 시작
        dec_dp[0] = 1;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        init(); // dp 초기화
        // 증가 부분
        for(int i=1;i<N;i++) {
            for(int j=0;j<i;j++) {
                if(arr[j] < arr[i]) {
                    inc_dp[i] = Math.max(inc_dp[i], inc_dp[j] + 1);
                }
            }
        }

        // 감소 부분 수열 N-1이 끝점이므로, N-2 시작
        for(int i=N-2;i>=0;i--) {
            for(int j=i+1;j<N;j++) {
                if(arr[j] < arr[i]) {
                    dec_dp[i] = Math.max(dec_dp[i], dec_dp[j] + 1);
                }
            }
        }


        // 이제 각각 부분 수열의 최대값을 찾는다
        int len = 0;
        for(int i=0;i<N;i++) {
            len = Math.max(len, inc_dp[i] + dec_dp[i] - 1);
        }

        System.out.println(len);
    }

    public static void init() {
        for(int i = 0; i < N; i++) {
            inc_dp[i] = 1;
            dec_dp[i] = 1;
        }
    }
}