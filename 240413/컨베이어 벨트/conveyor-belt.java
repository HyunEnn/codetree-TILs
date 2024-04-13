import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static int[] u;
    static int[] d;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        u = new int[N];
        d = new int[N];
        int time = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            u[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        while(time != T) {
            int tmp = u[N-1];

            for(int i=N-1;i>=1;i--) {
                u[i] = u[i-1];
            }
            u[0] = d[N-1];
            for(int i=N-1;i>=1;i--) {
                d[i] = d[i-1];
            }
            d[0] = tmp;

            time++;
        }

        for(int a : u) {
            System.out.print(a + " ");
        }
        System.out.println();
        for(int b : d) {
            System.out.print(b + " ");
        }
        System.out.println();

    }
}