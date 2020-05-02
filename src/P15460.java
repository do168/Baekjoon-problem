package BAEKJOON;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class P15460 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		ArrayList<Integer> score = new ArrayList<Integer>();
		ArrayList<Integer> minimum = new ArrayList<Integer>();
		int min=Integer.MAX_VALUE;
		str = new StringTokenizer(bfr.readLine());
		for (int i = 0; i < N; i++) {
			score.add(Integer.parseInt(str.nextToken()));
		}
		int sum = score.get(N-1);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		double avg = Integer.MIN_VALUE;
		for (int i = N-2; i>=1; i--) {
			int temp = score.get(i);
			sum+=temp;
			min = Math.min(min, temp);
			double tmp = (double)(sum-min)/(N-(i+1));
			if(avg==tmp) {
				ans.add(i);
			}						
			else if(avg<tmp) {
				avg = tmp;	
				ans.clear();
				ans.add(i);
			}
		}
		for(int i=ans.size()-1; i>=0; i--) {
			System.out.println(ans.get(i));
		}
	}
}