import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int people;
    static StringTokenizer st;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        v = new boolean[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 사람 찾기
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i][j] == 1 && !v[i][j]) {
                    people = 1;
                    v[i][j] = true;
                    findVillage(i, j, 0);
                    list.add(people);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());

        for(int i : list) {
            System.out.println(i);
        }
    }

    public static boolean inRange(int r, int c) {

        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static boolean checkPeople(int nr, int nc) {
        // 범위를 벗어나면 false
        if(!inRange(nr, nc)) {
            return false;
        }

        // 방문하지 않고, 사람이 있는지 체크
        if(!v[nr][nc] && map[nr][nc] == 1) {
            return true;
        }
        // 그 외의 경우 false
        return false;
    }

    public static void findVillage(int r, int c, int cnt) {

        for(int k=0;k<4;k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if(checkPeople(nr, nc)) {
                v[nr][nc] = true;
                people++;
                findVillage(nr, nc, cnt + 1);
            }
        }
    }
}