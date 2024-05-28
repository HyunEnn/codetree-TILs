import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static boolean[] line = new boolean[1000];
    static StringTokenizer st;
    static List<Point> list;
    static class Point {
        int x1, x2;
        Point(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            list.add(new Point(x1, x2));
        }
        recursive(0, 0);
        System.out.println(max);
    }

    public static void recursive(int ch, int cnt) {

        if(ch == list.size()) {
            max = Math.max(max, cnt);
            return;
        }

        int first = list.get(ch).x1;
        int last = list.get(ch).x2;
        for(int i=first;i<=last;i++) {
            if(line[i])
                recursive(ch+1, cnt);
            line[i] = true;
        }
        recursive(ch+1, cnt+1);
    }
}