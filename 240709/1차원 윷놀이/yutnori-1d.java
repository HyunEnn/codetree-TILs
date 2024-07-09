import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
//    static int[][] arr;
    static List<Integer> list = new ArrayList<>();
    static List<Integer> order = new ArrayList<>();
    static int[] model;
    static int max = Integer.MIN_VALUE;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
//        arr = new int[M][K];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        recursive(0);
        System.out.println(max);
    }

    public static void recursive(int idx) {

        // K개의 값들을 N개의 순열로 정리
        if(idx == N) {
            int cnt = 0;
            model = new int[K + 1]; // 매 번 탐색하고 초기화를 해줘야 함.
            for(int i=1;i<=K;i++) {
                model[i] += 1;
            }
//            for(int i=0;i<order.size();i++) {
//                System.out.print(order.get(i) + " ");
//            }
//            System.out.println();
            for(int i=0;i<order.size();i++) {
                model[order.get(i)] += list.get(i);
            }
            for(int i=1;i<=K;i++) {
                if(model[i] >= M) cnt++;
            }
            max = Math.max(max, cnt);
            return;
        }

        for(int i=1;i<=K;i++) {
            order.add(i);
            recursive(idx + 1);
            order.remove(order.size() - 1);
        }
    }
}