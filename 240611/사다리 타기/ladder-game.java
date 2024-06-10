import java.util.*;
import java.io.*;

public class Main {

    static class Pair implements Comparable<Pair> {

        int order;
        int loc;

        Pair(int order, int loc) {
            this.order = order;
            this.loc = loc;
        }

        @Override
        public int compareTo(Pair b) {
            if(order == b.order)
                return loc - b.loc;
            return order - b.order;
        }
    }
    static int N, M;
    static int ans = Integer.MAX_VALUE;
    static List<Pair> list = new ArrayList<>();
    static List<Pair> selectedPair = new ArrayList<>();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 사다리 수
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 현재 위치
            int b = Integer.parseInt(st.nextToken()); // 사다리 위치
            list.add(new Pair(b, a - 1));
        }

        Collections.sort(list);

        FindAnswer(0);

        System.out.println(ans);
    }

    public static void FindAnswer(int cnt) {

        if(cnt == M) {
            if(CheckLadder()) {
                ans = Math.min(ans, selectedPair.size());
            }
            return;
        }

        selectedPair.add(list.get(cnt));
        FindAnswer(cnt + 1);

        selectedPair.remove(selectedPair.size() - 1);
        FindAnswer(cnt + 1);
    }

    public static boolean CheckLadder() {

        int[] initArr = new int[N];
        int[] selectedArr = new int[N];

        // 초기값 설정
        for(int i=0;i<N;i++) {
            initArr[i] = selectedArr[i] = i;
        }

        // 기존 값에 대한 결과 처리
        for(int i=0;i<list.size();i++) {
            int idx = list.get(i).loc;
            int tmp = initArr[idx];
            initArr[idx] = initArr[idx+1];
            initArr[idx+1] = tmp;
        }

        // 선택된 값들에 대한 결과 처리
        for(int i=0;i<selectedPair.size();i++) {
            int idx = selectedPair.get(i).loc;
            int tmp = selectedArr[idx];
            selectedArr[idx] = selectedArr[idx+1];
            selectedArr[idx+1] = tmp;
        }

        // 선택된 조합과 기존 조합에 대한 비교 처리
        for(int i=0;i<N;i++) {
            if(initArr[i] != selectedArr[i])
                return false;
        }

        return true;
    }
}