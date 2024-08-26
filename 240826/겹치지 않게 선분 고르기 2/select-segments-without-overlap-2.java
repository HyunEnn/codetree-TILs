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
    static int N;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        size = 0;
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
        // recursive(first);
        // 1 2, 1 4, 3 4
        int lastEnd = -1;
        for(Pair p : list) {
            int s = p.start;
            int e = p.end;
            if(s > lastEnd) {
                size++;
                lastEnd = e;
            }
        }
        System.out.println(size);
    }
    // 예시로, 1이 first 로 지정되서 시작하면 (1,2) (1,4) -> (1,2)를 통해 recursive(2)로 드가면
    // 2의 list 가 있다면 size를 증가시키고 값을 뽑는다. 아니면 그대로 종료,

//    public static void recursive(int idx) {
//        System.out.println(idx);
//        if() // 값이 없으면 더해줄 값이 없는거니까, 있으면 1을 더해주고 다음값을 탐색?
//            size += 1;
//
//        // +1 이 아니라, 그냥 다음 값이 있으면 가야한다?
//        // 필요없고, 가장 짧은 걸 고른다는 기준하에면 많은 선을 만들수있다?
//    }
}

//