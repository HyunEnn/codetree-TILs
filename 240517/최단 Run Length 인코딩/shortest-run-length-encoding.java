import java.util.*;
import java.io.*;

public class Main {

    /**
     * 오른쪽으로 shift 를 해서, 나올 수 있는 최소의 경우를 구하면 된다.
     * HashMap 으로 처리하는 게 아니라, 오른쪽으로 shift를 진행하는데,
     * A.length - 1 만큼 진행해야 한다?
     */
    static String A;
    static char[] c;
    static int min;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        int answer = 0;
        min = Integer.MAX_VALUE;

        c = A.toCharArray();

        // 초기 값 체크 
        min = Math.min(min, checkValue());

        // 그 다음 shift를 진행하면서 값을 체크
        for(int i=0;i < c.length - 1;i++) {

            move();
            min = Math.min(checkValue(), min);
        }
        System.out.println(min);
    }

    public static void move() {

        char s = c[A.length()-1];
        for(int i=A.length()-1;i>0;i--) {
            c[i] = c[i-1];
        }
        c[0] = s;
    }

    public static int checkValue() {

        // A의 길이를 다 탐색하면서, 같으면 cnt 증가하고
        // 달라지면 sb에 값을 추가해준다.
        StringBuilder sb = new StringBuilder();
        char s = 'a';
        int cnt = 1;
        for(int i=0;i<c.length;i++) {
            if(i == 0) continue;
            if(c[i] == c[i-1]) {
                s = c[i];
                cnt++;
            }
            else {
                sb.append(s);
                sb.append(cnt);
                s = c[i];
                cnt = 1;
            }
        }
        sb.append(s);
        sb.append(cnt);

//        System.out.println(sb.toString());
        return sb.length();
    }

}