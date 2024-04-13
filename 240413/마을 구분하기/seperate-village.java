import java.io.*;
import java.util.*;
public class Main {
    static int N, cnt;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static List<Integer> list;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        list = new ArrayList<>();
        v = new boolean[N][N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 순열 체크
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(!v[i][j] && map[i][j] == 1) {
                    cnt = 1;
                    v[i][j] = true;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        for(int x : list) {
            System.out.println(x);
        }
    }

    public static void dfs(int r, int c) {
        // basis

        // inductive
        for(int i=0;i<4;i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nr < N && nc >= 0 && nc <N) {
                if(!v[nr][nc] && map[nr][nc] == 1) {
                    v[nr][nc] = true;
                    cnt++;
                    dfs(nr, nc);
                }
            }
        }
    }
}

/**
 * 1. map 입력을 통해서, 순열 방식으로 탐색하고자 하는 1을 찾는다.
 * 2. dfs 탐색 , 4방 탐색을 진행하며, 방문 배열 체크를 통해 마을 인원 수를
 * 체크하고, 리스트에 저장한다.
 * 3. 마을의 개수와 각 마을의 사람들을 오름차순 정렬을 통해서 정의한다.
 *
 * -> 단순 DFS
 */