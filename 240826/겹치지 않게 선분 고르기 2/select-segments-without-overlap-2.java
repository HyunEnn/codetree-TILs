import java.util.*;
import java.io.*;

public class Main {
    static class Pair implements Comparable<Pair> {
        int start, end;
        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
    static int[] arr;
    static int size;
    static List<Pair> list = new ArrayList<>();
    static int[] dp;
    static int N;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        size = 0;
        dp = new int[1001];
        dp[1] = 1;
        int first = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            first = start;
            int end = Integer.parseInt(st.nextToken());
            list.add(new Pair(start, end));
        } // 값들 저장
        // 정렬
        Collections.sort(list);
        func();
        int max = 0;
        for(int i=0;i<N;i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    public static void init(){
        for(int i=0;i<N;i++) {
            dp[i] = -1;
        }
        dp[0] = 1;
    }

    public static void func() {

        init();
        for(int i=1;i<N;i++) {
            for(int j=0;j<i;j++) {
                if(dp[j] == -1)
                    continue;
                if(inRange(list.get(j).start, list.get(j).end, list.get(i).start, list.get(i).end)){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else
                    dp[i] = Math.max(dp[i], 1);
            }
        }
    }

    public static boolean inRange(int start, int end, int start2, int end2) {
        return start2 > end || start > end2;
    }
}

//