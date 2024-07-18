import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Pair implements Comparable<Pair> {
        int r, c, idx;
        Pair(int r, int c, int idx) {
            this.r = r;
            this.c = c;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p) {
            return idx - p.idx;
        }
    }
    static int ans = Integer.MAX_VALUE;
    static List<Pair> list = new ArrayList<>();
    static int N;
    static int[] endR;
    static int[] endC;
    static char[][] map;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int startR = 0, startC = 0;
        endR = new int[1];
        endC = new int[1];
        map = new char[N][N];
        int a = '0';
        for(int i=0;i<N;i++) {
            String line = br.readLine();
            for(int j=0;j<N;j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'S') {
                    startR = i;
                    startC = j;
                    continue;
                }
                else if(map[i][j] == 'E') {
                    endR[0] = i;
                    endC[0] = j;
                    continue;
                }
                else if(Character.isDigit(map[i][j])) {
                    list.add(new Pair(i, j, (int)map[i][j] - '0'));
                }
            }
        }

        Collections.sort(list);
        recursive(startR, startC, 0, 0, 0);
        if(ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }

    public static void recursive(int r, int c, int cnt, int coin, int curr) {

        if(coin == 3) {
            int cal = calculate(endR[0], endC[0], r, c);
            ans = Math.min(ans, cnt + cal);
            return;
        }

        if(curr >= list.size()) {
            return;
        }

        Pair p = list.get(curr);
        int ch = calculate(p.r, p.c, r, c);
        // 동전을 선택한 경우
        recursive(p.r, p.c, cnt + ch, coin + 1, curr + 1);
        // 동전을 선택하지 않은 경우
        recursive(r, c, cnt, coin, curr + 1);
    }

    public static int calculate(int nr, int nc, int r, int c) {

        return Math.abs(r - nr) + Math.abs(c - nc);
    }
}