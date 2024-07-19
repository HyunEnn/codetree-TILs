import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    static int N, M;
    static int ans = Integer.MAX_VALUE;
    static List<Point> list = new ArrayList<>();
    static List<Point> sel = new ArrayList<>();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Point(r, c));
        }

        recursive(0, 0);
        System.out.println(ans);
    }

    public static int calculate(int first, int last) {

        Point a = sel.get(first);
        Point b = sel.get(last);

        return (int)Math.pow(
                Math.sqrt(
                        (int)(Math.pow((a.r - b.r), 2) + Math.pow((a.c - b.c), 2))), 2);
    }

    public static int diff() {

        int sum = Integer.MAX_VALUE;
        int currP = 0, lastP = 0;
        for(int i=0;i<sel.size()-1;i++) {
            Point p = sel.get(i);
            for(int j=i+1;j<sel.size();j++) {
                Point diffP = sel.get(i);
                int diffSum = (int)(Math.abs(p.r - diffP.r) + Math.abs(p.c - diffP.c));
                if(diffSum < sum) {
                    sum = diffSum;
                    currP = i;
                    lastP = j;
                }
            }
        }

        return calculate(currP, lastP);
    }

    public static void recursive(int cnt, int curr) {
        // 점 M 개를 선택하면, 점과 점 사이가 가장 먼 값을 채택한다.
        if(cnt == M) {
            ans = Math.min(ans, diff());
            return;
        }

        if(curr > N-1) {
            return;
        }

        // 현재 값을 가져오고 선택 값에 넣는다.
        Point p = list.get(curr);
        sel.add(new Point(p.r, p.c));
        // 선택했을 때
        recursive(cnt + 1, curr + 1);
        sel.remove(sel.size() - 1);

        // 선택안했을 때
        recursive(cnt, curr + 1);

    }

    /**
     * 우선 가장 거리가 먼 점과 점을 찾아야 함
     */
}