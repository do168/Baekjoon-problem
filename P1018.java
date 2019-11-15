package Fighting;
import java.util.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class P1018 {
	static int[][] Board;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		int N = Integer.parseInt(str.nextToken()); 
		int M = Integer.parseInt(str.nextToken());
		Board = new int[N][M];
		
		for (int i=0; i<N; i++) {
			String st = bfr.readLine();
			
			for (int j=0; j<M; j++) {
				
				Board[i][j] = st.charAt(j);
			}
		}
		
		
		int min = Integer.MAX_VALUE;
		for (int i=0; i<=N-8; i++) {
				
			for (int j=0; j<=M-8; j++) {
				min = Math.min(min, solve(i,j));
				
			}
		}
		
		System.out.println(min);
		
	}
	
	public static int solve (int x, int y) {
		int result_B = 0;
		int tmp_B = 'B';
		for (int i=x; i<x+8; i++) {
			if (Board[i][y] !=tmp_B) result_B++;
			for (int j=y+1; j<y+8; j++) {
				if(Board[i][j]==tmp_B) {
					result_B++;
					if (tmp_B=='B') tmp_B = 'W';
					else tmp_B='B';
				}
				else tmp_B=Board[i][j];
			}
		}
		
		int result_W = 0;
		int tmp_W = 'W';
		for (int i=x; i<x+8; i++) {
			if (Board[i][y] !=tmp_W) result_W++;
			for (int j=y+1; j<y+8; j++) {
				if(Board[i][j]==tmp_W) {
					result_W++;
					if (tmp_W=='B') tmp_W = 'W';
					else tmp_W='B';
				}
				else tmp_W=Board[i][j];
			}
		}
		
		return result_W>result_B?result_B:result_W;
	}

}
