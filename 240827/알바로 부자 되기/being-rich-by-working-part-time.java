import java.util.*;
import java.io.*;

public class Main {
    static class Pair implements Comparable<Pair> {
        int st, end, price;
        Pair(int st, int end, int price) {
            this.st = st;
            this.end = end;
            this.price = price;
        }

        @Override
        public int compareTo(Pair p) {
            if(this.st == p.st)
                return this.end - p.end;
            return this.st - p.st;
        }
    }
    static int N;
    static int[] dp;
    static List<Pair> list = new ArrayList<>();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Pair(a,b,c));
        }

        init();
        Collections.sort(list);

        for(int i=1;i<N;i++) {
            for(int j=0;j<i;j++) {
                if(inRange(list.get(j).st, list.get(j).end, list.get(i).st, list.get(i).end)) {
                    dp[i] = Math.max(dp[i], dp[j] + list.get(i).price);
                }
            }
        }

//        for(int i=0;i<N;i++) {
//            System.out.print(dp[i] + " ");
//        }

        int max = 0;
        for(int i=0;i<N;i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    public static boolean inRange(int st, int end, int nextSt, int nextEnd) {
        return nextSt > end || st > nextEnd;
    }

    public static void init() {
        for(int i=0;i<list.size();i++) {
            Pair p = list.get(i);
            dp[i] = p.price;
        }
    }
}