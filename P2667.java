package Fighting;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class P2667 {
	static int map[][];
	
	static int size;
	static int total=0;
	static int cnt;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		
		
		size = Integer.valueOf(str.nextToken());
		map = new int[size][size];
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for(int i=0; i<size; i++) {
			str = new StringTokenizer(bfr.readLine());
			String s = str.nextToken();
			String info[] = s.split("");
			for (int j=0; j<info.length; j++) {
				map[i][j] = Integer.valueOf(info[j]);
			}
		}
		
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (map[i][j] == 1) {
					cnt=0;
					total++;
					dfs(i, j);
					pq.add(cnt);
				}
			}
		}
		System.out.println(total);
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
	
	public static void dfs(int x, int y) {
		cnt++;
		map[x][y] = 0;
		for (int i=0; i<4; i++) {
			
			int tempx = x + dx[i];
			int tempy = y + dy[i];
			
			if (tempx >= 0 && tempx < size && tempy >= 0 && tempy < size) {
				if(map[tempx][tempy]==1) {
					dfs(tempx, tempy);
				}
			}
		}
	}

}
