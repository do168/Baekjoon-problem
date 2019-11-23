package Fighting;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class P2178 {
	static int[][] map;
    static boolean[][] visit;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int N;
    static int M;
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		N = Integer.valueOf(str.nextToken());
		M = Integer.valueOf(str.nextToken());
		
		map = new int[N+1][M+1];
		visit = new boolean [N+1][M+1];
		
		for (int i=0; i<N; i++) {
			str = new StringTokenizer(bfr.readLine());
			String s = str.nextToken();
			String[] temp = s.split("");
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
				visit[i][j] = false;
			}
		}
		
		
		visit[0][0] = true;
		BFS(0,0);
		System.out.println(map[N-1][M-1]);
		
	}
	public static void BFS(int x, int y) {
		Queue<Dot> q =new LinkedList<Dot>();
		q.add(new Dot(x,y));
		
		while(!q.isEmpty()) {
			Dot d = q.poll();
			
			for (int i=0; i<4; i++) {
				int nx = d.x+dx[i];
				int ny = d.y+dy[i];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                //이미 방문했던 점이면 건너뛰기
                if (visit[nx][ny] || map[nx][ny] == 0) {
                    continue;
                }
				
                q.add(new Dot(nx, ny));
                
                map[nx][ny] = map[d.x][d.y] + 1;
                visit[nx][ny] = true;
			}
		}
	}
	
}
class Dot{
	int x;
	int y;
	
	Dot(int x, int y){
		this.x = x;
		this.y = y;
	}
}
