import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int ans = Integer.MAX_VALUE;
    static int[] arr;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        recursive(0, 0);
        if(ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }

    public static void recursive(int idx, int cnt) {

        if(idx == N-1 ) {
            ans = Math.min(ans, cnt);
            return;
        }

        int curr = arr[idx];
        if(curr == 0)
            return;

        for(int i=1;i<=curr;i++)
            recursive(idx + i, cnt + 1);
    }
}