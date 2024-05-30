import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static boolean[] v;
    static List<Pair> pair = new ArrayList<>();
    static class Pair {
        int s, e;
        Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pair.add(new Pair(start, end));
        }
        for(int i=0;i<pair.size();i++) {
            v = new boolean[1001];
            recursive(i, 0);
        }
        System.out.println(max);
    }

    public static void recursive(int cnt, int check) {

        if(cnt == pair.size()) {
            max = Math.max(max, check);
            return;
        }

        int ns = pair.get(cnt).s;
        int ne = pair.get(cnt).e;
        boolean flag = false;
        for(int i=ns;i<=ne;i++) {
            if(v[i]) flag = true;
        }
        if(flag)
            recursive(cnt+1, check);
        else {
            for(int i=ns;i<=ne;i++) {
                v[i] = true;
            }
            recursive(cnt +1, check + 1);
        }
    }

}