//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//public class P14502 {
//    static int N;
//    static int M;
//    static int[][] map;
//    static Queue<Node> q;
//    static boolean[][] dfsisVisit;
//    static boolean[][] dfsisChecked;
//    static boolean[][] bfsisVisit;
//    static int cnt = 0;
//    static int[] dix = {-1, 1, 0, 0};
//    static int[] diy = {0, 0, -1, 1};
//    static int answer = 0;
//    public static void main(String[] args) throws IOException {
//        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer str = new StringTokenizer(bfr.readLine());
//        N = Integer.parseInt(str.nextToken());
//        M = Integer.parseInt(str.nextToken());
//        map = new int[N][M];
//        dfsisVisit = new boolean[N][M];
//        dfsisChecked = new boolean[N][M];
//        bfsisVisit = new boolean[N][M];
//        q = new LinkedList<>();
//
//
//        for (int i = 0; i < N; i++) {
//            String[] temp = bfr.readLine().split(" ");
//            for (int j = 0; j < M; j++) {
//                map[i][j] = Integer.parseInt(temp[j]);
//                if (map[i][j] == 0) {
//                    cnt++;
//                } else if (map[i][j] == 2) {
//                    q.add(new Node(i, j));
//                }
//            }
////        }
//        makewall(0, 0);
//        System.out.println(answer);
//    }
//    static void makewall(int start_x, int num) {
//        if (num == 3) {
//            bfs(map);
//            return;
//        }
//        for (int i = start_x; i < N * M; i++) {
//            int x = i / M;
//            int y = i % M;
//            if (map[x][y] == 0) {
//                map[x][y] = 1;
//                makewall(i + 1, num + 1);
//                map[x][y] = 0;
//            }
//        }
//        return;
//    }
//    static void bfs(int[][] map) {
//        int sum = cnt - 3;
//        int[][] tempmap = new int[N][M];
//        copy(tempmap, map);
//        Queue<Node> q1 = new LinkedList<>();
//        copyQueue(q1, q);
//        while (!q1.isEmpty()) {
//            Node n = q1.poll();
//            bfsisVisit[n.x][n.y] = true;
//            for (int i = 0; i < 4; i++) {
//                int x = n.x + dix[i];
//                int y = n.y + diy[i];
//                if (x < 0 || x >= N || y < 0 || y >= M)
//                    continue;
//                if (bfsisVisit[x][y])
//                    continue;
//                if (tempmap[x][y] != 0)
//                    continue;
//                bfsisVisit[x][y] = true;
//                tempmap[x][y] = 2;
//                sum--;
//                q1.offer(new Node(x, y));
//            }
//        }
//        InitBfs(bfsisVisit);
//        answer = Math.max(answer, sum);
//    }
//    static void copyQueue(Queue<Node> q1, Queue<Node> q2) {
//        Iterator it = q2.iterator();
//        while (it.hasNext()) {
//            q1.offer((Node) it.next());
//        }
//    }
//    static void InitBfs(boolean[][] bfsisVisit) {
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                bfsisVisit[i][j] = false;
//            }
//        }
//    }
//    static void copy(int[][] arr, int[][] arr2) {
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                arr[i][j] = arr2[i][j];
//            }
//        }
//    }
//}
