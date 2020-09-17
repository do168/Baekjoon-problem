//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class P10026 {
//    static int N;
//    static char[][] map;
//    static boolean[][] isVisit;
//    static int[] x_direction = {-1, 1, 0, 0};
//    static int[] y_direction = {0, 0, -1, 1};
//    static int count_1 = 0;
//    static int count_2 = 0;
//    static Queue<Node> q = new LinkedList<Node>();
//    public static void main(String[] args) throws IOException {
//        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer str = new StringTokenizer(bfr.readLine());
//        N = Integer.parseInt(str.nextToken());
//        map = new char[N][N];
//        isVisit = new boolean[N][N];
//        for(int i=0; i<N; i++) {
//            str = new StringTokenizer(bfr.readLine());
//            char[] temp = str.nextToken().toCharArray();
//            for (int j = 0; j < N; j++) {
//                map[i][j] = temp[j];
//            }
//        }
//        for (int i=0; i<N; i++) {
//            for(int j=0; j<N; j++) {
//                if(!isVisit[i][j]) {
//                    dfs(new Node(i, j));
//                    count_1++;
//                }
//            }
//        }
//
//        isVisit = new boolean[N][N];
//        for(int i=0; i<N; i++) {
//            for(int j=0; j<N; j++) {
//                if(map[i][j] == 'R')
//                    map[i][j] = 'G';
//            }
//        }
//        for (int i=0; i<N; i++) {
//            for(int j=0; j<N; j++) {
//                if(!isVisit[i][j]) {
//                    dfs(new Node(i, j));
//                    count_2++;
//                }
//            }
//        }
//        System.out.println(count_1+" "+count_2);
//    }
//    static void dfs(Node n) {
//        char color = map[n.x][n.y];
//        isVisit[n.x][n.y] = true;
//        q.add(n);
//
//        while(!q.isEmpty()) {
//            Node temp = q.poll();
//            int x_now = temp.x;
//            int y_now = temp.y;
//            for (int i = 0; i < 4; i++) {
//                int x = x_now + x_direction[i];
//                int y = y_now + y_direction[i];
//                if(x>=0&&x<N && y>=0 && y<N && color == map[x][y] && !isVisit[x][y]) {
//                    isVisit[x][y] = true;
//                    q.add(new Node(x,y));
//                }
//
//            }
//        }
//    }
//}
