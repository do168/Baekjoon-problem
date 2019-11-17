package Fighting;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class P15654 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		
		int N = Integer.valueOf(str.nextToken());
		int M = Integer.valueOf(str.nextToken());
		
		int[] list = new int[M];
		
		dfs(list, 0, N);
	}
	
	public static void dfs(int[] list, int i, int N) {
		if (i != list.length) {
			for (int j=1; j<=N; j++) {
				
				if(isPossible(list, j, i)) {
					list[i] = j;
					dfs(list, i+1, N);
				}
			}
			
		}
		else {
			for (int j=0; j<list.length; j++) {
				System.out.print(list[j]+" ");
			}
			System.out.println();
		}
	}
	public static boolean isPossible(int[] list, int find, int check) {
		for (int i=0; i<check; i++) {
			if(list[i]>=find) {
				return false;
			}
		}
		return true;
	}
}
