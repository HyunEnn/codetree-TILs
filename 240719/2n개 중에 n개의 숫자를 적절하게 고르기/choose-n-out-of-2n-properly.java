import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Pair {
        int idx, val;
        Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    static int N;
    static int ans = Integer.MAX_VALUE;
    static int[] arr;
    static List<Pair> selectedA = new ArrayList<>();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N*2];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N*2;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // N개씩 2개의 그룹으로 나눈다.
        // 나눈 그룹 간의 차가 최소가 되는 것을 구한다.
        // 예시로, [1,3,4]를 선택했다면 [2,5,6]을 고르게 해야함.
        // 이 상태에서 원소간의 차를 계산하자.
        recursive(0, 0);
        System.out.println(ans);
    }

    public static void recursive(int idx, int curr) {

        if(idx == N) {
            ans = Math.min(ans, calculate());
            return;
        }

        if(curr >= N*2) {
            return;
        }

        // 선택했다면
        selectedA.add(new Pair(curr, arr[curr]));
        recursive(idx + 1, curr + 1);
        selectedA.remove(selectedA.size() - 1);

        // 선택 안하면
        recursive(idx, curr + 1);
    }

    public static int calculate() {

        // 1,3,5를 선택했다면 2,4,6을 골라야 하는데 어떻게?
        List<Integer> unselectedB = new ArrayList<>();
        boolean[] selected = new boolean[N*2];

        for(Pair p : selectedA) {
            selected[p.idx] = true;
        }

        for(int i=0;i<N*2;i++) {
            if(!selected[i])
                unselectedB.add(arr[i]);
        }

        int sumA = 0, sumB = 0;
        for(int i=0;i<N;i++) {
            sumA += selectedA.get(i).val;
            sumB += unselectedB.get(i);
        }

        return (int)Math.abs(sumA - sumB);
    }
}