import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static StringTokenizer st;
    static int[] sel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        sel = new int[N];
        solve(0);
    }

    public static void solve(int cnt) {

        // basis
        if(cnt == N) {
            for(int i=0;i<N;i++) {
                System.out.print(sel[i] + " ");
            }
            System.out.println();
            return;
        }
            

        // inductive
        for(int i=1;i<=K;i++) {
            sel[cnt] = i;
            solve(cnt + 1); 
        }
    }
}