import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static StringTokenizer st;
    static int[][] map;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        v = new boolean[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++) { // 3
            for(int j=0;j<N-M;j++) { // 1번
                HashMap<Integer, Integer> hashMap = new HashMap<>();
                for(int k=j;k<j+M+1;j++) { 
                    hashMap.put(map[i][j], map.getOrDefault(map[i][j], 0) + 1);
                }
                Set<Integer> keySet = hashMap.keySet();
                for(Integer key : keySet) {
                    if(hashMap.get(key) >= M) 
                       v[key] = true; 
                }
            }
        }
        int answer = 0;
        for(int i=0;i<v.length;i++) {
            if(v[i]) 
                answer++;
        }
        System.out.println(answer);
    }
}