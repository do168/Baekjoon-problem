package BAEKJOON;
import java.util.*;
import java.io.*;
public class P15753 {
	static int[] log;
	static int min;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		log = new int[N+1];
		str = new StringTokenizer(bfr.readLine());
		for(int i=1; i<=N; i++) {
			log[i] = Integer.parseInt(str.nextToken());
		}
		int max_pnt = 0;
		min = 0;
		///////////////day 1에 대한 모순 검색 /////////////
		isBreakout(1);
		///////////////day 1에 대한 모순 검색 /////////////
		
		///////////////day n에 대한 모순 검색/////////////
		while(N>1) {
			if(N<=log[N]) {
				System.out.println("-1");
				return;
			}
			if(log[N]== -1) {
				max_pnt++;
				N--;
			}
			else if(log[N] == 0) {
				min++;
				N--;
			}
			else {
				for (int i=1; i<=log[N]; i++) {
					/////////////////breakout일어난 day인 경우//////////////
					if(i == log[N]) {
						isBreakout(N-i);
					}
					////////////////////////////////////////////////////
					//////////////////아직 카운트 중인 경우//////////////////////
					else {
						if(log[N-i]==log[N]-i || log[N-i]==-1) {
							if(N-i == 2) break;
						}
						else {
							System.out.println("-1");
							return;
						}
					}
					////////////////////////////////////////////////////
				}

				N= N-log[N]-1; //확실한 day들 제외 -> 그 전날day로 설정
			}
		}
		System.out.println(min+" "+(min+max_pnt));
	}
	
	static void isBreakout(int n) {
		if(log[n] == 0 || log[n] == -1) {
			min++;	
		}
		else {
			System.out.println("-1");
			return;
		}
	}

}
