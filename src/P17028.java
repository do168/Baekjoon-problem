package BAEKJOON;
import java.io.*;
import java.util.*;
public class P17028 {
	static ArrayList<Integer> cow;
	static int N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		N = Integer.parseInt(str.nextToken());
		cow = new ArrayList<Integer>();
		str = new StringTokenizer(bfr.readLine());
		int count=N-1;
		for (int i=0; i<N; i++) {
			cow.add(Integer.parseInt(str.nextToken()));
		}
	    for (int i=N-2; i>=0; i--) {
	    	if (cow.get(i)<cow.get(i+1))
	    		count = i;
	    	else 
	    		break;
	    }
		
		System.out.println(count);
	}
	
}
