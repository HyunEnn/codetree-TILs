import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static int[] fi;
    static int[] se;
    static int[] th;
    static int time;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        fi = new int[N];
        se = new int[N];
        th = new int[N];
        time = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            fi[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            se[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            th[i] = Integer.parseInt(st.nextToken());
        }

        while(time != T) {
            /**
            * 1. fi 행열 값 처리 후 , se 값으로 tmp 값 처리 후, 
            * 2. th 값까지 처리하고 time++, time과 정해진 T값이 일치하면 종료
            */
            int tmp = fi[N-1];
            for(int i=N-1;i>=1;i--) {
                fi[i] = fi[i-1];
            }
            fi[0] = th[N-1];

            int tmp2 = se[N-1];
            for(int i=N-1;i>=1;i--) {
                se[i] = se[i-1];
            }
            se[0] = tmp;

            // 마지막 행렬은 유실되는 값이 없으니, 바로 진행
            for(int i=N-1;i>=1;i--) {
                th[i] = th[i-1];
            }
            th[0] = tmp2;

            time++;
        }
        
        for(int x : fi) {
            System.out.print(x + " ");
        } System.out.println();
        for(int x : se) {
            System.out.print(x + " ");
        } System.out.println();
        for(int x : th) {
            System.out.print(x + " ");
        } System.out.println();
    }
}