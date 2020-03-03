package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2309 {
	final static int N = 9;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		int[] dwarf = new int[N];
		for (int i=0; i<N; i++) {
			str = new StringTokenizer(bfr.readLine());
			dwarf[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(dwarf);
		for (int i=0; i<(1<<N);i++) {
			int sum = 0;
			if(Integer.bitCount(i)==6) {
				for(int j=0; j<N; j++) {
					if((1<<j&i)>0) sum+=dwarf[j];
				}
			}
			if(sum==100) {
				for(int j=0; j<N; j++) {	
					if((1<<j&i)>0) System.out.println(dwarf[j]);
					
				}
				break;
			}
				
		}
		
	}

}
