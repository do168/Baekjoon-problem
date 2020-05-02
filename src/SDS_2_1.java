package BAEKJOON;
import java.util.*;
import java.io.*;

public class SDS_2_1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str= new StringTokenizer(bfr.readLine());
		
		int[][] sudoku = new int[9][9];
		int[] isVisit = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
		Queue<Integer> anscol = new LinkedList<Integer>();
		
		int n = Integer.parseInt(str.nextToken());
		int k = 0;
		for (int i=0; i<n; i++) {
			str =new StringTokenizer(bfr.readLine());
			k = Integer.parseInt(str.nextToken());
			for (int j =0; j<9; j++) {
				str = new StringTokenizer(bfr.readLine());
				for (int z=0; z<9; z++) {
					sudoku[j][z] = Integer.parseInt(str.nextToken());
					if (isVisit[sudoku[j][z]] == -1) {
						isVisit[sudoku[j][z]] = z;
					}
					else {
						anscol.add(z);
						anscol.add(isVisit[sudoku[j][z]]);
					}
				}
				for (int z=0; z<9; z++) {
					
				}
			}
			
			for (int c = 0; c<k; c++) {
				int x1 = anscol.poll();
				int x2 = anscol.poll();
			}
			
			
		}
	}

}
