package BAEKJOON;
import java.util.*;
import java.io.*;
public class P17200 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(bfr.readLine());
		int N = Integer.parseInt(str.nextToken());
		Graph gr = new Graph(N);
		for (int i=0; i<N; i++) {
			str = new StringTokenizer(bfr.readLine());
			int cnt_char = Integer.parseInt(str.nextToken());
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			for (int j=0; j<cnt_char; j++) {
				tmp.add(str.nextToken().hashCode());
			}
			for (int j=1; j<cnt_char; j++) {
				for (int z = j+1; z<cnt_char; z++) {
					gr.put(tmp.get(j), tmp.get(z));
				}
			}
		}
		for (int i=0;i<N; i++) {
			List<Integer> tmp = gr.getNode(i);
			for (int j=0; j<tmp.size(); j++) {
				int element = tmp.get(j);
				for (int z=0; z<tmp.size(); z++) {
					if(i==z) continue;
					else {
						if (!gr.getNode(j).contains(gr.getNode(element).get(z))) {System.out.println("no"); return;}
					}
				}
			}
		}
		System.out.println("yes");
	}

}
class Graph {
    private List<List<Integer>> graph;
    public Graph(int initSize) {
        this.graph = new ArrayList<>();
        for(int i = 0; i < initSize+1; i++) {
            graph.add(new ArrayList<>());
        }
    }
    public List<Integer> getNode(int x) {
        return this.graph.get(x);
    }
    public void put(int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
}