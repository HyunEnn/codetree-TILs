import java.util.*;
import java.io.*;

public class Main {
    static class Point implements Comparable<Point> {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Point p) {
            if(this.c == p.c)
                return this.r - p.r;
            return this.c - p.c;
        }
    }
    static int N;
    static List<Point> lines = new ArrayList<>();
    static int[] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[1001];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lines.add(new Point(x, y));
        }
        Collections.sort(lines);

        int cnt = 0;
        for(Point p : lines) {
            if(checkLine(p.r, p.c)) {
                cnt++;
                for(int i=p.r;i<=p.c;i++) dp[i]++;
            }
        }
        System.out.println(cnt);
    }

    public static boolean checkLine(int st, int end) {
        for(int i=st;i<=end;i++) {
            if(dp[i] != 0) return false;
        }
        return true;
    }
}