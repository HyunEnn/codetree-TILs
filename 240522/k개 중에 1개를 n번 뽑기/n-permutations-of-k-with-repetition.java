import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        solve(1, N);
    }

    public static void solve(int a, int b) {

        // basis
        if(a > N)
            return;

        // inductive
        for(int i=1;i<=K;i++) {
            System.out.println(a + " " + i);
        }

        solve(a + 1, b);
    }
}