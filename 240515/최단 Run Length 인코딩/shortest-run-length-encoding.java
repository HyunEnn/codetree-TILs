import java.util.*;
import java.io.*;

public class Main {

    static String A;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        int answer = 0;
        // 현재 값을 저장해야 함. 알파벳은 26개
        boolean[] v = new boolean[26];
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : A.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(char c : map.keySet()) {
            if(map.get(c) >= 10)
                answer += 3;
            else
                answer += 2;
        }
        System.out.println(answer);

//         마지막 값은 제외하고 반복문 실행
//        for(int i=0;i<A.length()-1;i++) {
//            v[A.charAt(i) - 97] = true;
//            for(int j=i+1;j<A.length();j++) {
//                if(A.charAt(j) == A.charAt(i))
//            }
//        }
    }
}