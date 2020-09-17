import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5213 {
    static int N;
    static int[][] tile;
    static boolean[][] isVisit;
    static String[][] navi;
    static int[][] x_dir = {{-1, 0, N-1}, {0, 1, N}};
    static int[] y_dir = {1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());
        N = Integer.parseInt(str.nextToken());
        tile = new int[N*N-N/2+1][2];
        isVisit = new boolean[N*N-N/2+1][2];
        navi = new String[N*N-N/2+1][2];
        for(int i=0; i<N*N-N/2; i++) {
            str = new StringTokenizer(bfr.readLine());
            tile[i][0] = Integer.parseInt(bfr.readLine());
            tile[i][1] = Integer.parseInt(bfr.readLine());
        }
        bfs(1,0);
    }
    static void bfs(int tile_num, int index) {
        Queue<Node5213> q= new LinkedList<>();
        q.add(new Node5213(tile_num, index, "1"));
        while (!q.isEmpty()) {
            Node5213 n = q.poll();
            isVisit[n.tile_num][n.start_index] = true;
            String navi = n.navi;
            int y = 1 - index;
            int x = tile_num;
            for(int i=0; i<3; i++) {
                x += x_dir[index][i];
                if(x%(2*N-1)==1 || x%(2*N-1)==N){
                    continue;
                }

                if (x < 1 || x > N || y < 0 || y > 1) {
                    continue;
                }
                if (isVisit[x][y])
                    continue;

                if(tile[tile_num][index] == tile[x][y]) {
//                    q.add(new Node(x,y, navi+" "));
                }
            }


        }


    }
}
class Node5213{
    int tile_num;
    int start_index;
    String navi="";
    Node5213(int tile_num, int start_index, String navi) {
        this.tile_num = tile_num;
        this.start_index = start_index;
        this.navi = navi;
    }
}
