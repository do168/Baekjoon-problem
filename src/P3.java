import java.util.ArrayList;

public class P3 {
    static boolean[] isnotleaf;
    static boolean[] ischecked;
    static ArrayList<ArrayList<Integer>> ar;
    public static void main(String[] args) {
        int total_sp = 121;
        int[][] skills = {{1, 2}, {1, 3}, {3, 6}, {3, 4}, {3, 5}};
        int[] answers = {};
        ar = new ArrayList<>();
        int length = skills.length;
        isnotleaf = new boolean[length+2];
        ischecked = new boolean[length+2];
        int[] num = new int[length+2];
        for(int i = 0; i < length+1; i++){
            ar.add(new<Integer> ArrayList());  //ad 리스트에 담을 리스트 초기화
        }



        for(int i=0; i<skills.length; i++) {
            ar.get(skills[i][0]).add(skills[i][1]);
            isnotleaf[skills[i][0]] = true;
        }
        int leaf_cnt = 0;
        for(int i=1; i<=length+1; i++) {
            if(!isnotleaf[i]) {
                leaf_cnt++;
                num[i] = 1;
            }
        }

        for(int i=0; i<skills.length; i++) {
            int up = skills[i][0];
            int down = skills[i][1];
            dfs(num, up, down);
            for(int j : num) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        for(int i : num) {
            System.out.println(i);
        }

    }
    static void dfs(int[] num, int up, int down) {
        if(num[down]!=0) {
            if(!ischecked[down]) {
                num[up] += num[down];
                ischecked[down] = true;
                return;
            }
        }
        else {
            for(int i=0; i<ar.get(down).size(); i++) {
                dfs(num, down, ar.get(down).get(i));
            }
            num[up]+=num[down];
        }
    }

}
