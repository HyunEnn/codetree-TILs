import java.util.*;
import java.io.*;

public class Main {
    static int[][] map = new int[4][4];
    static String dir;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dir = br.readLine();
        moveMap(dir);
        printMap();
    }

    public static void moveMap(String dir) {

        if (dir.equals("L")) {
            for (int i = 0; i < 4; i++) {
                moveAndCombineLeft(i);
            }
        } else if (dir.equals("R")) {
            for (int i = 0; i < 4; i++) {
                moveAndCombineRight(i);
            }
        } else if (dir.equals("U")) {
            for (int j = 0; j < 4; j++) {
                moveAndCombineUp(j);
            }
        } else if (dir.equals("D")) {
            for (int j = 0; j < 4; j++) {
                moveAndCombineDown(j);
            }
        }
    }

    public static void moveAndCombineLeft(int row) {
        int[] temp = new int[4];
        int idx = 0;
        // Move all numbers to the left
        for (int j = 0; j < 4; j++) {
            if (map[row][j] != 0) {
                temp[idx++] = map[row][j];
            }
        }
        // Combine same numbers
        for (int j = 0; j < 3; j++) {
            if (temp[j] != 0 && temp[j] == temp[j + 1]) {
                temp[j] *= 2;
                temp[j + 1] = 0;
            }
        }
        // Move again to the left after combining
        idx = 0;
        for (int j = 0; j < 4; j++) {
            if (temp[j] != 0) {
                map[row][idx++] = temp[j];
            }
        }
        while (idx < 4) {
            map[row][idx++] = 0;
        }
    }

    public static void moveAndCombineRight(int row) {
        int[] temp = new int[4];
        int idx = 3;
        // Move all numbers to the right
        for (int j = 3; j >= 0; j--) {
            if (map[row][j] != 0) {
                temp[idx--] = map[row][j];
            }
        }
        // Combine same numbers
        for (int j = 3; j > 0; j--) {
            if (temp[j] != 0 && temp[j] == temp[j - 1]) {
                temp[j] *= 2;
                temp[j - 1] = 0;
            }
        }
        // Move again to the right after combining
        idx = 3;
        for (int j = 3; j >= 0; j--) {
            if (temp[j] != 0) {
                map[row][idx--] = temp[j];
            }
        }
        while (idx >= 0) {
            map[row][idx--] = 0;
        }
    }

    public static void moveAndCombineUp(int col) {
        int[] temp = new int[4];
        int idx = 0;
        // Move all numbers up
        for (int i = 0; i < 4; i++) {
            if (map[i][col] != 0) {
                temp[idx++] = map[i][col];
            }
        }
        // Combine same numbers
        for (int i = 0; i < 3; i++) {
            if (temp[i] != 0 && temp[i] == temp[i + 1]) {
                temp[i] *= 2;
                temp[i + 1] = 0;
            }
        }
        // Move again up after combining
        idx = 0;
        for (int i = 0; i < 4; i++) {
            if (temp[i] != 0) {
                map[idx++][col] = temp[i];
            }
        }
        while (idx < 4) {
            map[idx++][col] = 0;
        }
    }

    public static void moveAndCombineDown(int col) {
        int[] temp = new int[4];
        int idx = 3;
        // Move all numbers down
        for (int i = 3; i >= 0; i--) {
            if (map[i][col] != 0) {
                temp[idx--] = map[i][col];
            }
        }
        // Combine same numbers
        for (int i = 3; i > 0; i--) {
            if (temp[i] != 0 && temp[i] == temp[i - 1]) {
                temp[i] *= 2;
                temp[i - 1] = 0;
            }
        }
        // Move again down after combining
        idx = 3;
        for (int i = 3; i >= 0; i--) {
            if (temp[i] != 0) {
                map[idx--][col] = temp[i];
            }
        }
        while (idx >= 0) {
            map[idx--][col] = 0;
        }
    }

    public static void printMap() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}