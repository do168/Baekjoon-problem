package BAEKJOON;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class P3078 {
	final static int namelimit = 20;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		int cnt=0;
		Queue<Integer>[] q = new Queue[namelimit+1];
		for (int i=0; i<namelimit+1; i++) {
			q[i] = new LinkedList<>();
		}
		for (int i=0;i<N;i++) {
			str = new StringTokenizer(bfr.readLine());
			int len = str.nextToken().length();
			if(q[len].isEmpty()) {
				q[len].add(i);
			}
			else {
				while(i-q[len].peek()>K) {
					q[len].poll();
					if(q[len].isEmpty())
						break;
				}
				cnt += q[len].size();
				q[len].add(i);
			}
		}
		System.out.println(cnt);
	}

}
