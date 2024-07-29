import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static boolean[] v;
    static int cnt;
    static List<Integer>[] graph;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        v = new boolean[N + 1];

        for(int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        cnt = 0;
        v[1] = true;
        DFS(1);
        System.out.println(cnt);
    }

    public static void DFS(int idx) {

        for(int i=0;i<graph[idx].size();i++) {
            int next = graph[idx].get(i);
            if(!v[next]) {
                v[next] = true;
                cnt++;
                DFS(next);
            }
        }
    }
}