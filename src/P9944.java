import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9944 {
    static int[] dir_x = {0 , 1, 0, -1};
    static int[] dir_y = {1, 0, -1, 0};
    static int N;
    static int M;
    static int answer = Integer.MAX_VALUE;
    static int empty_cnt=0;
    static boolean[][] isVisit;
    static boolean[][] Visit;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());
        int pr = 0;
        do {
            pr++;
            N = Integer.parseInt(str.nextToken());
            M = Integer.parseInt(str.nextToken());
            String[][] board = new String[N][M];
            isVisit = new boolean[N][M];
            for(int i=0; i<N; i++) {
                str = new StringTokenizer(bfr.readLine());
                String[] row = str.nextToken().split("");

                    for (int j = 0; j < M; j++) {
                        board[i][j] = row[j];
                        if(board[i][j].equals(".")) {
                            empty_cnt++;
                        }
                    }

            }

            for(int i=0; i<N*M; i++) {
                int x = i/M;
                int y = i%M;
                if(board[x][y].equals(".")) {
                    isVisit[x][y] = true;
                    bfs(board, x, y);
                    isVisit[x][y] = false;
                }
            }
            if(answer == Integer.MAX_VALUE) {
                System.out.println("Case "+pr+": "+"-1");
            }
            else {
                System.out.println("Case "+pr+": "+answer);
            }
            answer = Integer.MAX_VALUE;
            empty_cnt = 0;
            str = new StringTokenizer(bfr.readLine());
        } while(str.hasMoreTokens());
    }

    static void bfs(String[][] board, int x1, int y1) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x1, y1, 1));
        int cnt = 0;
        int empty = 1;
        while (!q.isEmpty()) {
            Node n = q.poll();
            int x = n.x;
            int y= n.y;
            isVisit[x][y] = true;
            int count  = n.cnt;
            System.out.println(x+" "+y+" "+count);
            if(count>=empty_cnt)
                break;
            for (int i = 0; i < 4; i++) {
                int nx = x + dir_x[i];
                int ny = y + dir_y[i];
                count = n.cnt;
                while (true) {
                    count++;
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        nx -= dir_x[i];
                        ny -= dir_y[i];
                        count--;
                        break;
                    }
                    if (board[nx][ny].equals("*")) {
                        nx -= dir_x[i];
                        ny -= dir_y[i];
                        count--;
                        break;
                    }

                    nx += dir_x[i];
                    ny += dir_y[i];

                }
                if(isVisit[nx][ny]) continue;
                empty = count;
                q.offer(new Node(nx,ny, count));
            }
            cnt++;
        }
        InitBfs(isVisit);
        if(empty>=empty_cnt) {
            answer = Math.min(answer, cnt);
        }

    }

    static void InitBfs(boolean[][] isVisit) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                isVisit[i][j] = false;
            }
        }
    }
}
