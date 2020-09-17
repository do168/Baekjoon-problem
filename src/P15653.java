//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class P15653 {
//    static int r_x;
//    static int r_y;
//    static int b_x;
//    static int b_y;
//    static int h_x;
//    static int h_y;
//    static int[] dir_x = {-1, 1, 0, 0};
//    static int[] dir_y = {0, 0, -1, 1};
//    static String[][] map;
//    static boolean[][][][] isVisit;
//    static int N;
//    static int M;
//    static int answer = 0;
//    static boolean flag;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer str = new StringTokenizer(bfr.readLine());
//
//        N = Integer.parseInt(str.nextToken());
//        M = Integer.parseInt(str.nextToken());
//        flag = false;
//        map = new String[11][11];
//        isVisit = new boolean[11][11][11][11];
//        for (int i = 0; i < N; i++) {
//
//            String[] temp = bfr.readLine().split("");
//
//            for (int j = 0; j < M; j++) {
//                map[i][j] = (temp[j]);
//                if (temp[j].equals("R")) {
//                    r_x = i;
//                    r_y = j;
//                } else if (temp[j].equals("B")) {
//                    b_x = i;
//                    b_y = j;
//                } else if (temp[j].equals("O")) {
//                    h_x = i;
//                    h_y = j;
//                }
//            }
//        }
//        isVisit[r_x][r_y][b_x][b_y] = true;
//        bfs(r_x, r_y, b_x, b_y);
//
//        System.out.println(answer);
//    }
//
//    static void bfs(int rx, int ry, int bx, int by) {
//        Queue<Node> q = new LinkedList<>();
//        q.offer(new Node(rx, ry, bx, by, 0));
//        while (!q.isEmpty()) {
//            Node n = q.poll();
//
//            int r_x = n.rx;
//            int r_y = n.ry;
//            int b_x = n.bx;
//            int b_y = n.by;
//            isVisit[r_x][r_y][b_x][b_y] = true;
//            for (int i = 0; i < 4; i++) {
//                int nrx = r_x + dir_x[i];
//                int nry = r_y + dir_y[i];
//                int nbx = b_x + dir_x[i];
//                int nby = b_y + dir_y[i];
//
//                while (true) {
//                    if (map[nrx][nry].equals("#")) {
//                        nrx -= dir_x[i];
//                        nry -= dir_y[i];
//                        break;
//                    }
//                    if (map[nrx][nry].equals("O")) break;
//                    nrx += dir_x[i];
//                    nry += dir_y[i];
//                }
//
//                while (true) {
//                    if (map[nbx][nby].equals("#")) {
//                        nbx -= dir_x[i];
//                        nby -= dir_y[i];
//                        break;
//                    }
//                    if (map[nbx][nby].equals("O")) break;
//                    nbx += dir_x[i];
//                    nby += dir_y[i];
//                }
//
//
//                if (nbx == h_x && nby == h_y) continue;
//                if (nrx == h_x && nry == h_y) {
//                    answer = n.cnt + 1;
//                    return;
//                }
//
//                if (nrx == nbx && nry == nby) {
//                    switch (i) {
//                        case 0: {
//                            if (r_x > b_x) {
//                                nrx++;
//                            } else {
//                                nbx++;
//                            }
//                            break;
//                        }
//                        case 1: {
//                            if (r_x < b_x) {
//                                nrx--;
//                            } else {
//                                nbx--;
//                            }
//                            break;
//                        }
//                        case 2: {
//                            if (r_y > b_y) {
//                                nry++;
//                            } else {
//                                nby++;
//                            }
//                            break;
//                        }
//                        case 3: {
//                            if (r_y < b_y) {
//                                nry--;
//                            } else {
//                                nby--;
//                            }
//                            break;
//                        }
//                    }
//                }
//
//                if (isVisit[nrx][nry][nbx][nby]) continue;
//                q.offer(new Node(nrx, nry, nbx, nby, n.cnt + 1));
//
//
//            }
//        }
//        answer =-1;
//    }
//
//
//}


class Node {
    int x;
    int y;
    int cnt;
    Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
//        this.bx = bx;
//        this.by = by;
//        this.cnt = cnt;
    }
}