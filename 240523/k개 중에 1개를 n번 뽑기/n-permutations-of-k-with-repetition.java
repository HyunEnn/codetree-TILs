import java.io.*;
import java.util.*;

public class Main {
    static int K, N;
    static StringTokenizer st;
    static List<Integer> sel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        sel = new ArrayList<>();
        recursive(0);
    }

    public static void recursive(int cnt) {

        // basis
        if(cnt == N) {
            for(int i : sel) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
            

        // inductive
        for(int i=1;i<=K;i++) {
            sel.add(i);
            recursive(cnt + 1);
            sel.remove(sel.size() - 1);
        }
    }
}